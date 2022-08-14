package dio.portifolio.geekapijwt.controller;

import dio.portifolio.geekapijwt.entity.UserMain;
import dio.portifolio.geekapijwt.repository.UserMainRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserMainController {

    private final UserMainRepository repository;
    private final PasswordEncoder encoder;

    public UserMainController(UserMainRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<UserMain>> listAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<UserMain> save(@RequestBody UserMain userMain) {
        userMain.setPassword(encoder.encode(userMain.getPassword()));
        return ResponseEntity.ok(repository.save(userMain));
    }

    @GetMapping("/pwdValidation")
    public ResponseEntity<Boolean> pwdValidation(@RequestParam String login,
                                                @RequestParam String password) {

        Optional<UserMain> optionalUserMain = repository.findByLogin(login);
        if (optionalUserMain.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        UserMain userMain = optionalUserMain.get();
        boolean valid = encoder.matches(password, userMain.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
