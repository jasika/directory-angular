package us.kulba.directory.config.securityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder registry) throws Exception {

        registry.inMemoryAuthentication()
            .withUser("user")
                .password("user")
                .roles("USER")
            .and()
            .withUser("admin")
                .password("admin")
                .roles("ADMIN", "USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/fonts/**");
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/lib/**");
        web.ignoring().antMatchers("/views/**");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//            .csrf().disable()
//            .authorizeRequests()
//            .antMatchers("/login", "/login/form**", "/register", "/logout").permitAll()
//            .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//            .loginPage("/login/form")
//            .loginProcessingUrl("/login")
//            .failureUrl("/login/form?error")
//            .permitAll();
//    }

}
