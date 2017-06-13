package com.sms.service;

import com.sms.dao.IAccountDao;
import com.sms.entities.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author el aoud
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private Logger log = Logger.getLogger(CustomUserDetailsService.class);

    @Autowired
    private IAccountDao accountDao;

    public static List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority(role));

        return authorities;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Account account = accountDao.getAcountByLogin(login);

        if (account == null) {

            log.info("user n'existe pas");

            throw new UsernameNotFoundException("User Not found" + login);

        }
        if (account.getCredential().getRole() == null) {
            log.error("role n'existe pas");
            throw new UsernameNotFoundException("no role for" + login);

        }

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        org.springframework.security.core.userdetails.User us = new org.springframework.security.core.userdetails.User(
                account.getCredential().getLogin(), account.getCredential().getPassword(),
                account.getState(), accountNonExpired, credentialsNonExpired, accountNonLocked,
                getGrantedAuthorities(account.getCredential().getRole()));
        log.info(us.toString());

        return us;
    }

}
