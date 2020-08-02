package club.codedemo.springsecurityexpressions.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping
    public String home() {
        return "home";
    }

    @RequestMapping("/aboutMe")
    public void aboutMe() {
    }

    @RequestMapping("/personalCenter")
    public void personalCenter() {
    }

    @RequestMapping("/systemConfig")
    public void systemConfig() {
    }
}
