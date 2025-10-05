package com.todo_app.Controller;

import com.todo_app.Input.CategoryInput;
import com.todo_app.Input.UserInput;
import com.todo_app.Model.User;
import com.todo_app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService UserService;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody UserInput input) {
        try {
            User user = UserService.create(input);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("User API is alive");
    }
}
