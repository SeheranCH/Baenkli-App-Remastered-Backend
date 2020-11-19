package ch.tbz.m326.BaenkliApplication.config.security;

import ch.tbz.m326.BaenkliApplication.domainModells.user.User;
import ch.tbz.m326.BaenkliApplication.domainModells.user.UserDetailsImpl;
import ch.tbz.m326.BaenkliApplication.domainModells.user.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private PropertyReader propertyReader;

    JWTAuthenticationFilter(
            RequestMatcher requiresAuthenticationRequestMatcher,
            AuthenticationManager authenticationManager,
            PropertyReader propertyReader,
            UserMapper userMapper) {
        super(requiresAuthenticationRequestMatcher);
        setAuthenticationManager(authenticationManager);
        this.propertyReader = propertyReader;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User creds = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword()));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException {
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
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

        response.setContentType("application/json");
    }
}
