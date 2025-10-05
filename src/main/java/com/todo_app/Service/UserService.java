package com.todo_app.Service;

import com.todo_app.Input.UserInput;
import com.todo_app.Model.User;
import com.todo_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(UserInput input) {
        User user = new User();
        user.setName(input.getName());
        user.setLastname(input.getLastName());
        user.setEmail(input.getEmail());
        user.setFecha_registro(LocalDate.now());
        return userRepository.save(user);
    }

}
