package dio.portifolio.geekapijwt.builder;

import lombok.Builder;
import dio.portifolio.geekapijwt.dto.request.GeekDTO;
import dio.portifolio.geekapijwt.entity.Film;
import dio.portifolio.geekapijwt.entity.Game;
import dio.portifolio.geekapijwt.entity.SuperHero;
import dio.portifolio.geekapijwt.enums.GameType;
import dio.portifolio.geekapijwt.enums.ProgrammingLanguageType;

import java.math.BigDecimal;
import java.util.List;

@Builder
public class GeekDTOBuilder {

    @Builder.Default
    private Long id = 11500L;

    @Builder.Default
    private String geekName = "Geek1000";

    @Builder.Default
    private String realName = "John Wick";

    @Builder.Default
    private List<Game> favoriteGame = (List<Game>) Game.builder().id(10L).name("Fortnite").gameStyle(GameType.FREEFIRE).price(new BigDecimal(0));

    @Builder.Default
    private List<SuperHero> favoriteSuperHero = (List<SuperHero>) SuperHero.builder().id(10L).name("Batman");

    @Builder.Default
    private List<Film> favoriteFilm = (List<Film>) Film.builder().id(10L).name("StarWars");

    @Builder.Default
    private boolean hasGlasses = true;

    @Builder.Default
    private ProgrammingLanguageType favoriteLanguage = ProgrammingLanguageType.JAVA;

    @Builder.Default
    private String birthDate = "01/10/2021";

    @Builder.Default
    private String email = "morty@gmail.com";

    public GeekDTO toGeekDTO() {
        return new GeekDTO(id, geekName, realName, favoriteGame, favoriteSuperHero, favoriteFilm, hasGlasses, favoriteLanguage, birthDate, email);
    }
}
