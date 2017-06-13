package com.sms.config;


import com.sms.service.Const;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author kel
 */
@Component
public class Redirect implements AuthenticationSuccessHandler {



    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication
                .getAuthorities());
        if (roles.contains(Const.Roles.ROLE_ADMIN)) {
            response.sendRedirect(Const.Roles.HOME_ADMIN);
            return;
        }

        if (roles.contains(Const.Roles.ROLE_USER)) {
            response.sendRedirect(Const.Roles.HOME_SMS);

        }

    }

}
