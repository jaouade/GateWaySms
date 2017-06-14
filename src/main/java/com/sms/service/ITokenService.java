package com.sms.service;

import com.sms.entities.Token;

/**
 * Created by kel on 14/06/17.
 */
public interface ITokenService extends Iservice<Token> {
    Token getTokenByToken(String token);
    Token getTokenByEmail(String email);
}