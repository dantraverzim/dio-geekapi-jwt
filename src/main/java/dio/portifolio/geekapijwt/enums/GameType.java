package dio.portifolio.geekapijwt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameType {

    FREEFIRE("FreeFire"),
    RPG("Rpg"),
    ADVENTURE("Adventure"),
    OTHER("Other");

    private final String description;
}
