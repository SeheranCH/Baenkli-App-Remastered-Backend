package ch.tbz.m326.BaenkliApplication.config.security;

import ch.tbz.m326.BaenkliApplication.config.security.util.JwtUtil;
import ch.tbz.m326.BaenkliApplication.domainModells.user.User;
import ch.tbz.m326.BaenkliApplication.domainModells.user.UserDTO;
import ch.tbz.m326.BaenkliApplication.domainModells.user.UserDetailsImpl;
import ch.tbz.m326.BaenkliApplication.domainModells.user.UserService;
import ch.tbz.m326.BaenkliApplication.domainModells.user.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private PropertyReader propertyReader;
    private Logger logger;
    private UserMapper userMapper;
    private JwtUtil jwtUtil;
    private UserService userService;

    JWTAuthenticationFilter(
            RequestMatcher requiresAuthenticationRequestMatcher,
            AuthenticationManager authenticationManager,
            PropertyReader propertyReader,
            Logger logger,
            UserMapper userMapper) {
        super(requiresAuthenticationRequestMatcher);
        setAuthenticationManager(authenticationManager);
        this.propertyReader = propertyReader;
        this.logger = logger;
        this.userMapper = userMapper;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User creds = new ObjectMapper().readValue(request.getInputStream(), User.class);
            Authentication auth = getAuthenticationManager()
                    .authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword()));
            return auth;
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException {
        /*UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetailsImpl.getUser();
        String subject = user.getId();

        String token = Jwts.builder().setSubject(subject).setExpiration(new Date(System.currentTimeMillis() + propertyReader.getIntProperty("jwt.expiration-time")))
                .signWith(SignatureAlgorithm.HS512, propertyReader.getStringProperty("jwt.secret").getBytes())
                .compact();
        response.addHeader(propertyReader.getStringProperty("jwt.header-string"),
                propertyReader.getStringProperty("jwt.token-prefix") + token);
        // expose the Headers
        response.addHeader("Access-Control-Expose-Headers", propertyReader.getStringProperty("jwt.header-string") );

        // Put the user into the response body

        String userString = new ObjectMapper().writeValueAsString(user);

        response.getWriter().write(userString);

        response.setContentType("application/json");*/

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) auth.getPrincipal();
        User user = userDetailsImpl.getUser();
        String subject = user.getId();

        jwtUtil = new JwtUtil();
        String token = jwtUtil.generateToken(new UserDetailsImpl(user));

        res.addHeader(propertyReader.getStringProperty("jwt.header-string"),
                token);
        // Expose the Headers
        res.addHeader("Access-Control-Expose-Headers", propertyReader.getStringProperty("jwt.header-string") );

        // Put the user's ID and roles into the response body
        UserDTO userDTO = userMapper.toDTO(user);

        String userDTOString = new ObjectMapper().writeValueAsString(userDTO);

        res.getWriter().write(userDTOString);

        res.setContentType("application/json");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
    }
}
