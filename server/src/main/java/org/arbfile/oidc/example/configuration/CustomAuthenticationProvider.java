package org.arbfile.oidc.example.configuration;

import org.arbfile.oidc.example.oauth.CustomOidcUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.authentication.OAuth2LoginAuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider
{
    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
    private CustomOidcUserService customOidcUserService;

    public CustomAuthenticationProvider(CustomOidcUserService customOidcUserService)
    {
        this.customOidcUserService = customOidcUserService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        logger.info("CustomAuthenticationProvider executing...");
        Object user = authentication.getPrincipal();
        if (user instanceof DefaultOidcUser)
        {
            logger.info("principal is instanceof DefaultOidcUser");
            DefaultOidcUser authToken = (DefaultOidcUser) user;
            this.customOidcUserService.loadUserByUsername(authToken.getClaims().get("preferred_username").toString());
        }

        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return OAuth2LoginAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
