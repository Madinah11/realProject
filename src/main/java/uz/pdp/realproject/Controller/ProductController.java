package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.Product;
import uz.pdp.realproject.payload.ProductDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping
    public Result add(@RequestBody ProductDto productDto){
        Result result = productService.add(productDto);
        return result;
    }

    @GetMapping
    public List<Product> get(){
        List<Product> products = productService.get();
        return products;
    }

    @GetMapping("/{id}")
    public Product getByID(@PathVariable Integer id){
        Product productById = productService.getById(id);
        return productById;

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = productService.delete(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody ProductDto productDto){
        Result result = productService.edit(id, productDto);
        return result;
    }

}
