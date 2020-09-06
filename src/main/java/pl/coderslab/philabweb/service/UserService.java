package pl.coderslab.philabweb.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.coderslab.philabweb.entities.User;
import pl.coderslab.philabweb.dto.UserRegistrationDto;

import java.util.HashSet;
import java.util.List;

public interface UserService extends UserDetailsService {
    HashSet<User> findAllPatientsByMedic(User medic);
    User save(UserRegistrationDto registrationDto);

    User findUserbyId(Long medicId);

    User findUserByEmail(String name);

    User edit(UserRegistrationDto registrationDto);
}

