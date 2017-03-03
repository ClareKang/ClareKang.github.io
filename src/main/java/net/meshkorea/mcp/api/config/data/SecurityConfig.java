package net.meshkorea.mcp.api.config.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.Filter;
import java.util.Arrays;

/**
 * Created by sungjae.hong on 2017. 2. 27..
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("1");
        http
                .authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().failureForwardUrl("/login?error");
        http.addFilterAfter(new SpringAuthorizationFilter(), BasicAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("2");
        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .userSearchFilter("(objectClass=*)")
                .groupSearchBase("ou=groups")
                .contextSource(contextSource())
                .passwordCompare()
                //.passwordEncoder(new LdapShaPasswordEncoder())
                .passwordAttribute("userPassword");
    }

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        System.out.println("3");
        return  new DefaultSpringSecurityContextSource(Arrays.asList("ldap://10.5.1.251:389/"), "dc=meshcorp,dc=com");
    }
}
