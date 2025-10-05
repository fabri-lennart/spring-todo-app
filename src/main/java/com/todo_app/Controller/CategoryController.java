package com.todo_app.Controller;

import com.todo_app.Input.CategoryInput;
import com.todo_app.Service.CategoryService;
import com.todo_app.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody CategoryInput input) {
        try {
            Category category = categoryService.create(input);
            return new ResponseEntity<>(category, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
