package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.InputProduct;
import uz.pdp.realproject.entity.OutputProduct;
import uz.pdp.realproject.payload.InputProductDto;
import uz.pdp.realproject.payload.OutputProductDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.service.InputProductService;
import uz.pdp.realproject.service.OutputProductService;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutProductController {
    @Autowired
    OutputProductService outputProductService;


    @PostMapping
    public Result add(@RequestBody OutputProductDto outputProductDto){
        Result result = outputProductService.add(outputProductDto);
        return result;
    }

    @GetMapping
    public List<OutputProduct> get(){
        List<OutputProduct> outputProducts = outputProductService.get();
        return outputProducts;
    }

    @GetMapping("/{id}")
    public OutputProduct getByID(@PathVariable Integer id){
        OutputProduct outputProductServiceById = outputProductService.getById(id);
        return outputProductServiceById;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = outputProductService.delete(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody OutputProductDto outputProductDto){
        Result result = outputProductService.edit(id, outputProductDto);
        return result;
    }

}
