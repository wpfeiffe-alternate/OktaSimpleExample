package org.arbfile.oidc.example.controller;

import org.arbfile.oidc.example.dto.AuthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController
{
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/isauthenticated")
    @CrossOrigin("http://localhost:4200")
    public AuthUser isAuthenticated()
    {
        AuthUser authUser = new AuthUser("");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
        {
            Object p = authentication.getPrincipal();
            logger.info("Principal class name = " + p.getClass());
            authUser = new AuthUser("jkennedy");
        }
        return authUser;
    }

}
