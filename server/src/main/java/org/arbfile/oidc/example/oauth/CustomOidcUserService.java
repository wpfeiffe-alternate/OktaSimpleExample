package org.arbfile.oidc.example.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class CustomOidcUserService extends OidcUserService
{
    private Logger logger = LoggerFactory.getLogger(CustomOidcUserService.class);

    public CustomOidcUserService() {
        logger.info("constructor...");
    }

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException
    {
        OidcUser user = super.loadUser(userRequest);
        logger.info("CustomOidcUserService user = " + user.getPreferredUsername());
        return user;
    }

}
