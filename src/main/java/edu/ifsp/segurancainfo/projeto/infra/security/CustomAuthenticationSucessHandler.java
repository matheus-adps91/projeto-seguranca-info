package edu.ifsp.segurancainfo.projeto.infra.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSucessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException
    {
        var authorities = authentication.getAuthorities();

        boolean isAdmin = authorities.stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        boolean isUser = authorities.stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_USER"));

        if (isAdmin) {
            response.sendRedirect("/administradores");
        } else if (isUser) {
            response.sendRedirect("/usuarios");
        } else {
            response.sendRedirect("/index");
        }
    }
}
