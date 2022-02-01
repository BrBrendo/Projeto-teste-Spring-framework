package com.funcionarios.testeapi.config;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
                .csrf().disable(); //desabilita proteção contra requisições forçadas
    }

    public void configureGlobal(AuthenticationManagerBuilder auth){
        auth.inMemoryAuthentication()
                .withUser("Brendo").password("new123").roles("USER")
                .and()
                .withUser("admin").password("new123").roles("USER","ADMIN");


    }

}
