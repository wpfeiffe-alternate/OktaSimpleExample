package org.arbfile.oidc.example.controller;

import org.arbfile.oidc.example.dto.AuthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController
{
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/isauthenticated")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<AuthUser> isAuthenticated()
    {
        AuthUser authUser = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
        {
            Object principal = authentication.getPrincipal();
            logger.info("Principal class name = " + principal.getClass());
            if (principal instanceof DefaultOidcUser)
            {
                DefaultOidcUser authToken = (DefaultOidcUser) principal;
                Map<String, Object> claims = authToken.getClaims();
                String loginId = (String) claims.get("preferred_username");
                logger.info("loginId for the user = " + loginId);
                authUser = new AuthUser(loginId);
            }
            else
            {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null); //403
            }
        }
        else
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); //401
        }
        return ResponseEntity.ok().body(authUser);
    }

}
