package pl.rynski.chomiczek_workout.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/styles/**", "/images/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/confirm-account").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/").permitAll()
                .loginProcessingUrl("/processlogin").permitAll()
                .defaultSuccessUrl("/secret", true)
                .failureForwardUrl("/error")
                .usernameParameter("user")
                .passwordParameter("pass")
                .and()
                .logout()
                .logoutUrl("/logmeout")
                .logoutSuccessUrl("/")
                .permitAll();
    }
}
