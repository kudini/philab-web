package pl.coderslab.philabweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.philabweb.entities.Role;
import pl.coderslab.philabweb.repositories.RoleRepository;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> findByName(String roleUser) {
        return roleRepository.findByName(roleUser);
    }
}
