package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.realproject.entity.Category;
import uz.pdp.realproject.entity.Supplier;
import uz.pdp.realproject.payload.CategoryDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Result add(CategoryDto categoryDto) {
        Category category1 = new Category();
        category1.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId()==null){
            category1.setParentCategory(null);
        }
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalCategory.isPresent())
                return new Result("such a parent category does not exist", false);
            Category parentCategory = optionalCategory.get();
            category1.setParentCategory(parentCategory);
        }
        categoryRepository.save(category1);
        return new Result("Category saved", true);
    }

    public List<Category> get() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    public Category getById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            return category;
        }
        return new Category();
    }

    public Result delete(Integer id) {
        try {
            categoryRepository.deleteById(id);
            return new Result("Category deleted", true);
        } catch (Exception exception) {
            return new Result("Category not found", false);
        }
    }

    public Result edit(Integer id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("Category not found", false);
        Category editingCategory = optionalCategory.get();
        editingCategory.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalCategory2 = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalCategory2.isPresent())
                return new Result("such a parent category does not exist", false);
            Category parentCategory = optionalCategory2.get();
            editingCategory.setParentCategory(parentCategory);
        }

        categoryRepository.save(editingCategory);
        return new Result("Category edited", true);
    }
}
