package com.navonmesh.navonrulette.security.filter;

import com.navonmesh.navonrulette.model.Authentication;
import com.navonmesh.navonrulette.security.model.KeyBasedAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class ApplicationJwtAuthenticationFilter extends BasicAuthenticationFilter {


    public ApplicationJwtAuthenticationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse, FilterChain chain)
            throws IOException, ServletException {
        String apiKeyHeader = httpServletRequest.getHeader("API_KEY");
        String tenantIdHeader = httpServletRequest.getHeader("TENANT_ID");

        if (apiKeyHeader == null || tenantIdHeader == null) {
            chain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }


        KeyBasedAuthenticationToken authentication =
                new KeyBasedAuthenticationToken(
                        "API_USER",
                        Authentication.builder()
                                .apiKey(apiKeyHeader)
                                .tenantId(tenantIdHeader)
                                .build(),
                        Collections.emptyList()
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(httpServletRequest, httpServletResponse);
    }
}
