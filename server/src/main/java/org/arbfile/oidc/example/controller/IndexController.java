package org.arbfile.oidc.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Map;

@Controller
public class IndexController
{
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private Environment environment;

//    @RequestMapping({"/", "/index"})
    @RequestMapping("/secure")
    public String index(Principal principal, Model model)
    {
        if (principal == null)
        {
            logger.info("Principal was not found");
        }
        else
        {
            logger.info(principal.toString());
            logger.info("principal.getName() = " + principal.getName());
            if ( principal instanceof OAuth2AuthenticationToken)
            {
                logger.info("principal is instanceof OAuth2AuthenticationToken");
                OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) principal;
                // OAuth2User at runtime == DefaultOidcUser
                OAuth2User user = authToken.getPrincipal();
                logger.info("preferred_username = " + user.getAttributes().get("preferred_username"));
            }
            // Authentication at runtime == OAuth2AuthenticationToken
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Object user = authentication.getPrincipal();
            if (user instanceof DefaultOidcUser)
            {
                logger.info("principal is instanceof DefaultOidcUser");
                DefaultOidcUser authToken = (DefaultOidcUser) user;
                Map<String, Object> claims = authToken.getClaims();
                String loginId = (String) claims.get("preferred_username");
                logger.info("preferred_username(2) = " + loginId);
            }
        }
        model.addAttribute("profile", this.environment.getActiveProfiles()[0]);
        return "index_orig";
    }

    @RequestMapping({"/welcome"})
    public String welcome(Principal principal, Model model)
    {
        if (principal == null)
        {
            logger.info("Principal was not found");
            model.addAttribute("name", "");
        }
        else
        {
            if ( principal instanceof OAuth2AuthenticationToken)
            {
                OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) principal;
                OAuth2User user = authentication.getPrincipal();
                model.addAttribute("name", user.getAttributes().get("preferred_username"));
            }
        }
        return "welcome";
    }
}
