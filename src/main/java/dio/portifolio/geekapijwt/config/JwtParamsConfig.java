package dio.portifolio.geekapijwt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:jwt.properties")
public class JwtParamsConfig {
    public static String jwtHeader;

    @Value("${java-jwt.jwtHeader}")
    public void setJwtHeader(String jwtHeader) {
        JwtParamsConfig.jwtHeader = jwtHeader;
    }
    public static String jwtPrefix;
    @Value("${java-jwt.jwtPrefix}")
    public void setJwtPrefix(String jwtPrefix) {
        JwtParamsConfig.jwtPrefix = jwtPrefix;
    }
    public static String jwtGuid;
    @Value("${java-jwt.jwtGuid}")
    public void setjwtGuid(String jwtGuid) {
        JwtParamsConfig.jwtGuid = jwtGuid;
    }
    public static int jwtExpirationMs;
    @Value("${java-jwt.jwtExpirationMs}")
    public void setjwtExpirationMs(int jwtExpirationMs) {
        JwtParamsConfig.jwtExpirationMs = jwtExpirationMs;
    }

}
