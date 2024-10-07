package com.restfullapi.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Authenticating...");
        String token = request.getHeader("Authorization");
        token = token != null ? token.substring(7) : null;

        String username = null;
        if(token != null) {
            log.info("Extracting credentials...");
            Claims claims = jwtService.parseJwt(token);
            username = claims.get("username", String.class);
        }

        if(username != null){
            log.info("Setting authentication...");
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, List.of());
            auth.setDetails(new WebAuthenticationDetails(request));
            SecurityContextHolder.getContext().setAuthentication(auth);
            log.info("Authentication successful.");
        }

        filterChain.doFilter(request, response);
    }
}
