package com.example.project.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * 生成token和验证token
 */
public class JWTUtil {
    private static final String SIGNATURE = "jokennnn!@#$%^7890";
    /**
     * 生成token
     * @param map //传入payload
     * @return 返回token
     */
    public static String getToken(Map<String,String> map){
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)-> builder.withClaim(k,v));
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR,7);
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(SIGNATURE)).toString();
    }

    /**
     * 获取token中payload
     * @param token
     * @return
     */
    public static DecodedJWT getToken(String token){
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }

    /**
     * 验证token
     * @param token
     */
    public static void verify(String token) {
        JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }
}
