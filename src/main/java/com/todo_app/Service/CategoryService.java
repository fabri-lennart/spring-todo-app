package com.todo_app.Service;

import com.todo_app.Input.CategoryInput;
import com.todo_app.Model.Category;
import com.todo_app.Model.User;
import com.todo_app.Repository.CategoryRepository;
import com.todo_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    public Category create(CategoryInput input) {
        Category category = new Category();
        category.setName(input.getName());

        User user = userRepository.findById(input.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        category.setUser(user);

        return categoryRepository.save(category);
    }
}
