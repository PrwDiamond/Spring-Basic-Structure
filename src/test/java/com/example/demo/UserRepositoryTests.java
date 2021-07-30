package com.example.demo;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void testCreateUser() {

        Role role = new Role();
        role.setName("user");
//        roleRepository.save(role);

        User user = new User();
        user.setEmail("Piratw@gmail.com");
        user.setPassword("12345");
        user.setFirstname("Pirat");
        user.setLastname("Wannasiripipat");

        Role byName = roleRepository.findById("1c2e595f-aabd-490d-9e83-3eef3ab1a228").get();
        user.addRole(byName);

        userRepository.save(user);
    }


    @Test
    public void testAddRolesToExistingUser(){

        Role roleUser = roleRepository.findByName("user").get();
        Role roleAdmin = roleRepository.findByName("admin").get();

        Optional<User> byUser = userRepository.findById("e2b2ad1e-43d0-4948-82de-e9f5897d8300");
        User user = byUser.get();
        user.addRole(roleUser);
        user.addRole(roleAdmin);

        userRepository.save(user);
    }
}
