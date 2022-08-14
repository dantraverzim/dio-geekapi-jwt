package dio.portifolio.geekapijwt.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import dio.portifolio.geekapijwt.config.JwtParamsConfig;
import dio.portifolio.geekapijwt.data.UserDetailsData;
import dio.portifolio.geekapijwt.entity.UserMain;
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
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            UserMain usuario = new ObjectMapper()
                    .readValue(request.getInputStream(), UserMain.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    usuario.getLogin(),
                    usuario.getPassword(),
                    new ArrayList<>()
            ));

        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar usuario", e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UserDetailsData usuarioData = (UserDetailsData) authResult.getPrincipal();

        String token = JWT.create().
                withSubject(usuarioData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtParamsConfig.jwtExpirationMs))
                .sign(Algorithm.HMAC512(JwtParamsConfig.jwtGuid));

        response.getWriter().write(token);
        response.getWriter().flush();
    }
}















