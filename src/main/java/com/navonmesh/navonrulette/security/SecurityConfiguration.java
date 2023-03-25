package com.navonmesh.navonrulette.security;


import com.navonmesh.navonrulette.security.filter.ApplicationJwtAuthenticationFilter;
import com.navonmesh.navonrulette.security.model.KeyBasedAuthenticationToken;
import com.navonmesh.navonrulette.model.TenantInfo;
import com.navonmesh.navonrulette.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Configuration("SecurityConfiguration")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private VendorService vendorService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new AuthenticationProvider() {

            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                com.navonmesh.navonrulette.model.Authentication auth = (com.navonmesh.navonrulette.model.Authentication)authentication.getCredentials();
                Optional<TenantInfo> tenantInfoOptional = vendorService.findTenantInfoByTenantId(auth.getTenantId());
                if(tenantInfoOptional.isPresent() && tenantInfoOptional.get().getApiKey().equals(auth.getApiKey())) {
                    return new KeyBasedAuthenticationToken(
                            auth,
                            authentication.getCredentials(),
                            Collections.singletonList(new SimpleGrantedAuthority("RULE_ENGINE_EXECUTOR")),
                            true
                    );
                }

                throw new BadCredentialsException("Authentication Failed");
            }

            @Override
            public boolean supports(Class<?> aClass) {
                return aClass.equals(KeyBasedAuthenticationToken.class);
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .anyRequest().authenticated().and()
                .headers().frameOptions().disable()
                .and().addFilter(new ApplicationJwtAuthenticationFilter(this.authenticationManager()))
                .exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPoint() {

                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
                        response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
                    }
                });
    }


    @Bean("PasswordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
