package dio.portifolio.geekapijwt.repository;

import dio.portifolio.geekapijwt.entity.Geek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface GeekRepository extends JpaRepository<Geek, Long> {

    Optional<Geek> findByGeekName(String geekName);
}
