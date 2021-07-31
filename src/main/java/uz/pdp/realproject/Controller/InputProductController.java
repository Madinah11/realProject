package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.Input;
import uz.pdp.realproject.entity.InputProduct;
import uz.pdp.realproject.payload.InputDto;
import uz.pdp.realproject.payload.InputProductDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.service.InputProductService;
import uz.pdp.realproject.service.InputService;

import java.util.List;

@RestController
@RequestMapping("/inputProduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;


    @PostMapping
    public Result add(@RequestBody InputProductDto inputProductDto){
        Result result = inputProductService.add(inputProductDto);
        return result;
    }

    @GetMapping
    public List<InputProduct> get(){
        List<InputProduct> inputProducts = inputProductService.get();
        return inputProducts;
    }

    @GetMapping("/{id}")
    public InputProduct getByID(@PathVariable Integer id){
        InputProduct InputProductbyId = inputProductService.getById(id);
        return InputProductbyId;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = inputProductService.delete(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody InputProductDto inputProductDto){
        Result result = inputProductService.edit(id, inputProductDto);
        return result;
    }


}
