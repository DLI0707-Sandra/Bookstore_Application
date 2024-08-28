package com.example.Bookstore.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenUtillity{

    public final String SECRET = "SecretKey";
    public String createToken(Long emp_id){
        return JWT.create()
                .withClaim("emp_id",emp_id)
                .sign(Algorithm.HMAC256(SECRET));
    }

    public Long decodeToken(String token){
        Long id = 0L;
        if(token!=null){
            id=JWT.require(Algorithm.HMAC256(SECRET))
                    .build().verify(token).getClaim("emp_id").asLong();
        }
        return id;
    }
}
