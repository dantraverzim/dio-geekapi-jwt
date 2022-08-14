package dio.portifolio.geekapijwt.service;

import dio.portifolio.geekapijwt.data.UserDetailsData;
import dio.portifolio.geekapijwt.entity.UserMain;
import dio.portifolio.geekapijwt.repository.UserMainRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMainRepository repository;

    public UserDetailsServiceImpl(UserMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserMain> usuario = repository.findByLogin(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }

        return new UserDetailsData(usuario);
    }

}
