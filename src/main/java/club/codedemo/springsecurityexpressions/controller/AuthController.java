package club.codedemo.springsecurityexpressions.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/test")
    public String test() {
        return "{\"/foo\":\"/admin-bar\"}";
    }
}
