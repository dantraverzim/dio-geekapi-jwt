package dio.portifolio.geekapijwt.repository;

import dio.portifolio.geekapijwt.entity.UserMain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMainRepository extends JpaRepository<UserMain, Integer> {

    public Optional<UserMain> findByLogin(String login);

}
