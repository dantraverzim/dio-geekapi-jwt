package dio.portifolio.geekapijwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeekAlreadyRegisteredException extends Exception {

    public GeekAlreadyRegisteredException(String geekName) {
        super(String.format("Geek with name %s already registered in the system.", geekName));
    }

}
