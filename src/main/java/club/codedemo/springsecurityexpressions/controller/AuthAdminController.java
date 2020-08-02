package club.codedemo.springsecurityexpressions.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/admin")
public class AuthAdminController {

    @RequestMapping("/test")
    public String test() {
        return "{\"/foo\":\"/auth/admin-bar\"}";
    }
}
