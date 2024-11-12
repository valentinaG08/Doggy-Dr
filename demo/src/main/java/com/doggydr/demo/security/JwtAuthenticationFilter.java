package com.doggydr.demo.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTGenerator jwtGenerator;

    @Autowired
    private CustomUserDetailService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
     HttpServletResponse response,
     FilterChain filterChain)
            throws ServletException, IOException {

        
        System.out.println("JwtAuthenticationFilter ejecutado para: " + request.getRequestURI());


        String token = getJWT(request);

        //System.out.println("Token extraído: " + token);

        if (token != null && jwtGenerator.validateToken(token)) {

            System.out.println("\n\nEl token es válido");

            String username = jwtGenerator.getUserFromJwt(token);
            System.out.println("UserName extraído del token: " + username);

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
           
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails,null, userDetails.getAuthorities()
            );
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            System.out.println("Autenticación configurada para el usuario: " + username);

        } else {
            System.out.println("El token es inválido o no está presente");
        }

        filterChain.doFilter(request, response);
    }

    private String getJWT(HttpServletRequest request){

        //System.out.println("Authorization Header: " + request.getHeader("Authorization"));

        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "");
        }
        return null;
    }
    
    
}