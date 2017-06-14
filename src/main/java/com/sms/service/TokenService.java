package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.TokenDao;
import com.sms.entities.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by kel on 14/06/17.
 */
@org.springframework.stereotype.Service
public class TokenService extends Service<Token> implements ITokenService {
    private TokenDao tokenDao;
    public TokenService(){

    }
    @Autowired
    public TokenService(
            @Qualifier("tokenDao") IDao<Token> genericDao) {
        super(genericDao);
        this.tokenDao = (TokenDao) genericDao;
    }

    @Override
    public Token getTokenByToken(String token) {
        return tokenDao.getTokenByToken(token);
    }

    @Override
    public Token getTokenByEmail(String email) {
        return tokenDao.getTokenByEmail(email);
    }
}
