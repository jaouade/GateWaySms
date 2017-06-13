package com.sms.dao;

import com.sms.entities.Token;

public interface ITokenDao extends IDao<Token> {
    Token getTokenByToken(String token);
    Token getTokenByEmail(String email);
}
