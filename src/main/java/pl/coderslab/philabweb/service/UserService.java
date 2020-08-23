package pl.coderslab.philabweb.service;

import org.springframework.stereotype.Service;
import pl.coderslab.philabweb.entities.User;
import pl.coderslab.philabweb.repositories.UserRepository;
@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findUserbyId(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
