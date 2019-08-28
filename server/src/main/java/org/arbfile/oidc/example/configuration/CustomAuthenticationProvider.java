package org.arbfile.oidc.example.configuration;

import org.arbfile.oidc.example.oauth.CustomOidcUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

public class CustomAuthenticationProvider implements AuthenticationProvider
{
    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
    private CustomOidcUserService customOidcUserService;

    public CustomAuthenticationProvider() {}

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
            this.customOidcUserService.loadUser(new OidcUserRequest(null, null, null));
        }

        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return true;
    }
}
