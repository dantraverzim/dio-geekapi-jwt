package dio.portifolio.geekapijwt.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dio.portifolio.geekapijwt.config.JwtParamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
public class JWTValidationFilter extends BasicAuthenticationFilter {
    public JWTValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String atributo = request.getHeader(JwtParamsConfig.jwtHeader);

        if (atributo == null) {
            chain.doFilter(request, response);
            return;
        }

        if (!atributo.startsWith(JwtParamsConfig.jwtPrefix)) {
            chain.doFilter(request, response);
            return;
        }

        String token = atributo.replace(JwtParamsConfig.jwtPrefix, "");
        token = token.replace(" ", "");
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(token);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {

        String usuario = JWT.require(Algorithm.HMAC512(JwtParamsConfig.jwtGuid))
                .build()
                .verify(token)
                .getSubject();

        if (usuario == null) {
            return null;
        }

        return new UsernamePasswordAuthenticationToken(usuario,null, new ArrayList<>());
    }
}
