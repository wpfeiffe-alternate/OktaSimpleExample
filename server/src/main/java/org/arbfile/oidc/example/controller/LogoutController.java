package org.arbfile.oidc.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController
{
    @GetMapping("/lo")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "index";
    }
}
