package com.mg.store.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mg.store.config.exception.UnauthorizedException;
import com.mg.store.entity.User;
import com.mg.store.service.JwtService;
import com.mg.store.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader(org.springframework.http.HttpHeaders.AUTHORIZATION);

        final String requestPath = request.getServletPath();

        logger.info("Request path: {}", requestPath);

        if (requestPath.contains("/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            logger.warn("No se ingresó el token de autorización.");
        } else {
            final String jwt = authHeader.substring(7);
            final String username = jwtService.extractUsername(jwt);
            if (username == null || SecurityContextHolder.getContext().getAuthentication() != null) {
                throw new UnauthorizedException("Usuario no encontrado.");
            }
            User user = userService.getByUserName(username);

            if (!jwtService.isTokenValid(jwt, user)) {
                throw new UnauthorizedException("Token inválido o expirado");
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}