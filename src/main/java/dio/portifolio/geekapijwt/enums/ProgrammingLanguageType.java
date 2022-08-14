package dio.portifolio.geekapijwt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum ProgrammingLanguageType {

    JAVA("Java"),
    OTHER("Other");

    private final String description;

}
