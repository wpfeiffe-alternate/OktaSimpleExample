package org.arbfile.oidc.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class IndexController
{
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping({"/", "/index"})
    public String index(Principal principal)
    {
        if (principal == null)
        {
            logger.info("Principal was not found");
        }
        else
        {
            logger.info(principal.toString());
            if ( principal instanceof OAuth2AuthenticationToken)
            {
                OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) principal;
                OAuth2User user = authentication.getPrincipal();
                logger.info("username = " + user.getAttributes().get("preferred_username"));
            }
        }
        return "index";
    }
}
