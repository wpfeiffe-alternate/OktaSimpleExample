package org.arbfile.oidc.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController
{
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/nglogin")
    @CrossOrigin("http://localhost:4200")
    public RedirectView login(HttpServletResponse response, HttpSession session, RedirectAttributes redirAttr)
    {
        if (response != null)
        {
            logger.info("response successfully injected");
        }
        if (session != null)
        {
            logger.info("session successfully injected");
        }
        redirAttr.addAttribute("loginParam", "test");
        return new RedirectView("http://localhost:4200/");
    }

}
