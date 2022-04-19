package br.com.tcc.security;

import br.com.tcc.DTO.LoginDTO;
import br.com.tcc.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAutenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;

    @Autowired
    UserService userService;

    public JWTAutenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {

        try {
            LoginDTO login = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginDTO.class);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword(), new ArrayList<>());

            Authentication auth = authenticationManager.authenticate(authToken);
            return auth;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest req,
                                         HttpServletResponse res,
                                         FilterChain chain,
                                         Authentication auth) throws IOException, ServletException {

        var userName = ((UserSS) auth.getPrincipal()).getUsername();
        var token = jwtUtil.generateToken(userName);
        res.addHeader("Authorization", "Bearer " + token);

        res.getWriter().write(userName);
    }


}
