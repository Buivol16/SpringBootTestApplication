package ua.denys.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.denys.model.User;
import ua.denys.repository.UserRepository;

@Component
@AllArgsConstructor
public class UserFacade {
    private UserRepository userRepository;

    public User findUser(long id) {
        return userRepository.findById(id).get();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
