package kg.edu.university.schedule.auth;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByEmailIgnoreCase(request.email())
                .filter(entity -> entity.passwordMatches(request.password()))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Неверный email или пароль"
                ));
        return user.toResponse();
    }
}
