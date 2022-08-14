package dio.portifolio.geekapijwt.entity;

import dio.portifolio.geekapijwt.enums.ProgrammingLanguageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import java.time.LocalDate;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Geek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String geekName;

    @Column(nullable = false)
    private String realName;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Game> favoriteGame;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<SuperHero> favoriteSuperHero;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Film> favoriteFilm;

    @Column(nullable = true)
    private boolean hasGlasses;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProgrammingLanguageType favoriteLanguage;

    private LocalDate birthDate;

    @Column(nullable = true)
    private String email;

}
