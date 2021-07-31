package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.Input;
import uz.pdp.realproject.entity.Output;
import uz.pdp.realproject.payload.InputDto;
import uz.pdp.realproject.payload.OutputDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.service.InputService;
import uz.pdp.realproject.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;


    @PostMapping
    public Result add(@RequestBody OutputDto outputDto){
        Result result = outputService.add(outputDto);
        return result;
    }

    @GetMapping
    public List<Output> get(){
        List<Output> outputs = outputService.get();
        return outputs;
    }

    @GetMapping("/{id}")
    public Output getByID(@PathVariable Integer id){
        Output byId = outputService.getById(id);
        return byId;

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = outputService.delete(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody OutputDto outputDto){
        Result result = outputService.edit(id, outputDto);
        return result;
    }

}
