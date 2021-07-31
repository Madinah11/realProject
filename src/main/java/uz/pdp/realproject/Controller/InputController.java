package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.Input;
import uz.pdp.realproject.entity.Product;
import uz.pdp.realproject.payload.InputDto;
import uz.pdp.realproject.payload.ProductDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.service.InputService;
import uz.pdp.realproject.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;


    @PostMapping
    public Result add(@RequestBody InputDto inputDto){
        Result result = inputService.add(inputDto);
        return result;
    }

    @GetMapping
    public List<Input> get(){
        List<Input> inputs = inputService.get();
        return inputs;
    }

    @GetMapping("/{id}")
    public Input getByID(@PathVariable Integer id){
        Input input = inputService.getById(id);
        return input;

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = inputService.delete(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody InputDto inputDto){
        Result result = inputService.edit(id, inputDto);
        return result;
    }

}
