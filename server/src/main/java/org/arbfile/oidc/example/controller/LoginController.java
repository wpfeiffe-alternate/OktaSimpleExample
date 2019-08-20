package org.arbfile.oidc.example.controller;

import org.arbfile.oidc.example.configuration.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController
{
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    private ApplicationProperties properties;
    private Environment environment;

    public LoginController(ApplicationProperties properties, Environment environment)
    {
        this.properties = properties;
        this.environment = environment;
    }

    /**
     * Handles Angular login.  This link is under security and can be redirected to from
     * an Angular application.
     * @param request needed to display cookies for debugging purposes.
     * @param response not used currently.
     * @param session not used currently.
     * @param redirAttr used to build a redirect request.  Not used.
     * @return an object that represents a view that redirects to an absolute,
     * context relative, or current request relative URL.
     */
    @GetMapping("/nglogin")
    @CrossOrigin("http://localhost:4200")
    public RedirectView login(HttpServletRequest request, HttpServletResponse response, HttpSession session, RedirectAttributes redirAttr)
    {
        if (response != null)
        {
            logger.info("response successfully injected");
        }
        if (session != null)
        {
            logger.info("session successfully injected");
        }
        Cookie[] cookies = request.getCookies();
        logger.info("All Cookies:");
        for (Cookie c: cookies)
        {
            logger.info("\t" + c.getName() + ":" + c.getValue());
        }
        logger.info("active profile = " + environment.getActiveProfiles()[0]);
        // the below code will add query params to the redirect url
        //redirAttr.addAttribute("loginParam", "test");
        return new RedirectView(this.properties.getPostauthredirect());
    }

}

// Notes:
// interesting SO post sending cookies back with redirect
// https://stackoverflow.com/questions/4694089/sending-browser-cookies-during-a-302-redirect

// get the active profile
// https://stackoverflow.com/questions/9267799/how-do-you-get-current-active-default-environment-profile-programmatically-in-sp
