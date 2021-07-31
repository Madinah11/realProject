package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.Category;
import uz.pdp.realproject.entity.Supplier;
import uz.pdp.realproject.payload.CategoryDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.service.CategoryService;
import uz.pdp.realproject.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.add(categoryDto);
        return result;
    }

    @GetMapping
    public List<Category> get(){
        List<Category> categories = categoryService.get();
        return categories;
    }

    @GetMapping("/{id}")
    public Category getByID(@PathVariable Integer id){
        Category categoryServiceById = categoryService.getById(id);
        return categoryServiceById;

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = categoryService.delete(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        Result result = categoryService.edit(id, categoryDto);
        return result;
    }

}
