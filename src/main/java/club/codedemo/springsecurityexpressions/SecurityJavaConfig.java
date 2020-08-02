package club.codedemo.springsecurityexpressions;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password(passwordEncoder().encode("user"))
            .authorities("ROLE_USER")
            .and().withUser("admin").password(passwordEncoder().encode("admin"))
            .authorities("ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/auth/admin/*").hasRole("ADMIN") // 本行代码与下一行等价
//            .antMatchers("/auth/admin/*").hasAuthority("ROLE_ADMIN")
//            .antMatchers("/auth/*").hasAnyRole("ADMIN", "USER") // 本行代码与下一行等价
            .antMatchers("/auth/*").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
            .antMatchers("/systemConfig").denyAll()
            .antMatchers("/message").rememberMe()
            .antMatchers("/*").permitAll()
            .antMatchers("/aboutMe").anonymous()
            .antMatchers("/balance").fullyAuthenticated()
            .and().httpBasic()
        ;
    }
}
