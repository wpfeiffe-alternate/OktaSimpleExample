package org.arbfile.oidc.example.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

@Component
public class CustomOidcUserService implements UserDetailsService
{
    private Logger logger = LoggerFactory.getLogger(CustomOidcUserService.class);


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        logger.info("running AF user service with " + username);
        return null;
    }

    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException
    {
        //OidcUser user = super.loadUser(userRequest);
//        logger.info("running AF user service");
//        CustomOidcUser afUser = new CustomOidcUser((DefaultOidcUser)user);
//        return user;
        return null;
    }
}
