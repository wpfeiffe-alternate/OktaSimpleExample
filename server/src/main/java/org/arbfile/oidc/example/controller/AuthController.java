package org.arbfile.oidc.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AuthController
{
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

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
        for (Cookie c: cookies)
        {
            logger.info(c.getName() + ":" + c.getValue());
        }
        redirAttr.addAttribute("loginParam", "test");
        response.addHeader("loginid", "jkennedy");
        return new RedirectView("http://localhost:4200/");
    }

}
