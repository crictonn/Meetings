package com.example.meetings.service;

import com.example.meetings.controller.request.RegisterRequest;
import com.example.meetings.model.Person;
import com.example.meetings.model.User;
import com.example.meetings.repository.PersonRepository;
import com.example.meetings.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long getUserID(String username){
        return userRepository.findUserByUsername(username).get().getId();
    }

    public RegisterRequest getAllData(String username){
        User user = userRepository.findUserByUsername(username).orElseThrow();
        Person person = personRepository.findPersonById(getUserID(username)).orElseThrow();
        return RegisterRequest.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .username(username)
                .age(person.getAge())
                .gender(person.getGender())
                .email(user.getEmail())
                .role(user.getRole())
                .build();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User '%s' not found", username)
        ));
        return User.build(user);
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }

    public ResponseEntity<?> changeUserDetails(RegisterRequest request){
        User user = userRepository.findUserByEmail(request.getEmail()).orElseThrow();
        var newUser = User.builder()
                .id(user.getId())
                .username(request.getUsername())
                .email(user.getEmail())
                .role(request.getRole())
                .build();
        userRepository.delete(user);
        userRepository.save(newUser);
        return ResponseEntity.ok("User changed");
    }
}
