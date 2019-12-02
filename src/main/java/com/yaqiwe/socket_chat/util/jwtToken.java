package com.yaqiwe.socket_chat.util;


import com.yaqiwe.socket_chat.dto.tokenDto;
import com.yaqiwe.socket_chat.enums.exceEnum;
import com.yaqiwe.socket_chat.exception.socketException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 0:14
 * @description：Token生成以及校验
 */
@Slf4j
public class jwtToken {
    //token过期时间
    private final static long EXPIRE_TIME=2*60*60*1000;
    //签名密钥
    private final static byte[] SECRET= DatatypeConverter.parseBase64Binary("socket_jwt");

    /**
     * 生成Token
     * @param dto  储存在token里面的用户信息
     * @return
     */
    public static String getToken(tokenDto dto){
        //签名算法
        SignatureAlgorithm algorithm=SignatureAlgorithm.HS256;

        //获取当前时间
        long nowMillis=System.currentTimeMillis();

        Key key = new SecretKeySpec(SECRET, algorithm.getJcaName());
        //生成JWT
        JwtBuilder jwt= Jwts.builder()
                .setHeaderParam("type","jwt")
                .signWith(algorithm,key)
                .claim("userId",dto.getUserId())
                .claim("userName",dto.getUserName())
                .claim("role",dto.getRole());
        //设置有效时间
        Date now=new Date(nowMillis);
        Date expire_time=new Date(nowMillis+EXPIRE_TIME);
        jwt.setExpiration(expire_time).setNotBefore(now);
        log.info("token :{}",jwt.compact());
        return jwt.compact();
    }


    /**
     * 解析token
     * @param token
     * @return
     */
    public static tokenDto pareJwt(String token){
        Claims body=null;
        try {
             body= Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new socketException(exceEnum.TOKEN_EXPIRED);
        }  catch (MalformedJwtException e) {
            throw new socketException(exceEnum.TOKEN_INVALID);
        } catch (Exception e) {
            throw new socketException(exceEnum.TOKEN_ERROR);
        }
        tokenDto dto=new tokenDto();
        dto.setUserName((String) body.get("userName"));
        dto.setUserId((Integer) body.get("userId"));
        dto.setRole((String) body.get("role"));
        return dto;
    }


}
