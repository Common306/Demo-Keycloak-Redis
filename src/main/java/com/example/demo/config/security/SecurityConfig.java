package com.example.demo.config.security;


import com.example.demo.config.keycloak.KeycloakGrantedAuthoritiesConverter;
import com.example.demo.exception.CustomOAuth2AccessDeniedHandler;
import com.example.demo.exception.CustomOAuth2AuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakGrantedAuthoritiesConverter());
        return jwtAuthenticationConverter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                    .anyRequest().permitAll()
                    .and()
                .oauth2ResourceServer()
                    .jwt()
                    .jwtAuthenticationConverter(jwtAuthenticationConverter());

        http.oauth2ResourceServer()
                .authenticationEntryPoint(new CustomOAuth2AuthenticationEntryPoint())
                .accessDeniedHandler(new CustomOAuth2AccessDeniedHandler());
    }
}
