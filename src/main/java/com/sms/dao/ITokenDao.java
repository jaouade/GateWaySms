package com.sms.dao;

import com.sms.entities.Token;
import org.springframework.stereotype.Repository;

@Repository

public interface ITokenDao extends IDao<Token> {
    Token getTokenByToken(String token);
    Token getTokenByEmail(String email);
}
