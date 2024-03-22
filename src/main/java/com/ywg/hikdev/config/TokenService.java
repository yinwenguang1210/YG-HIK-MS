package com.ywg.hikdev.config;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public void securityCheck(String token) throws Exception {
        if(!token.equals("86d17c41-4de9-470a-a637-0acb7237099d")){
            throw new Exception("token error");
        }
    }
}
