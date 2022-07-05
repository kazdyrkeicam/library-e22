package com.example.securityspringdemo.template;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("home")
    public String getHome() {
        return "homepage";
    }

    @GetMapping("admin_panel")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAdminPanel() {
        return "admin_panel";
    }
}
