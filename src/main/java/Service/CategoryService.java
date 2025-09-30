package Service;

import Input.CategoryInput;
import com.todo_app.Model.Category;
import com.todo_app.Repository.CategoryRepository;
import com.todo_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public Category create(CategoryInput input) {
        Category category = new Category();
        category.setName(input.getName());
        return categoryRepository.save(category);
    }
}
