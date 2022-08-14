package dio.portifolio.geekapijwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GeekNotFoundException extends Exception {

    public GeekNotFoundException(Long id) {
        super(String.format("Geek not found Id --> ", id));
    }
    public GeekNotFoundException(String name) {
        super(String.format("Geek not found name --> ", name));
    }
}
