package pl.coderslab.philabweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.philabweb.dto.UserRegistrationDto;
import pl.coderslab.philabweb.entities.Role;
import pl.coderslab.philabweb.entities.User;
import pl.coderslab.philabweb.repositories.PatientCardRepository;
import pl.coderslab.philabweb.repositories.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private RoleService roleRepository;
    private UserRepository userRepository;
    private PatientCardRepository patientCardRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(PatientCardRepository patientCardRepository, UserRepository userRepository, RoleService roleRepository) {
        super();
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.patientCardRepository = patientCardRepository;
    }

    @Override
    public HashSet<User> findAllPatientsByMedic(User medic) {
        HashSet<User> userHashSet = new HashSet<>();
        patientCardRepository.findAllByInvolvedPeopleIsContaining(medic).stream()
            .map(element ->userHashSet.add(element.getPatient()));
        return userHashSet;
    }
//
//    @Override
//    public List<User> findAllPatientsByMedic(User medic) {
//        HashSet<User> userHashSet = new HashSet<>();
//        patientCardRepository.findAllByInvolvedPeopleIsContaining(medic).stream()
//            .map(element ->userHashSet.add(element.getPatient()));
//        return null;
//    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()),
                Arrays.asList(roleRepository.findByName("ROLE_USER").get()));
//todo enum do roli
        return userRepository.save(user);
    }

    public User edit(UserRegistrationDto registrationDto) {
        User user = userRepository.findById(registrationDto.getId()).get();
        user.UserDTOToUser(registrationDto);
        return userRepository.save(user);
    }

    public User findUserbyId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
