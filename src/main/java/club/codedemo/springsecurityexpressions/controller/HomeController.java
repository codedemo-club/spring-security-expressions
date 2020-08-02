package club.codedemo.springsecurityexpressions.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping
    public String home() {
        return who();
    }

    @RequestMapping("/personalCenter")
    public String personalCenter() {
        return who();
    }

    @RequestMapping("/systemConfig")
    public String systemConfig() {
        return who();
    }

    @RequestMapping("/aboutMe")
    public String aboutMe() {
        return who();
    }

    @RequestMapping("/balance")
    public String balance() {
        return who();
    }



    private String who() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext.getAuthentication().getName();
    }
}
