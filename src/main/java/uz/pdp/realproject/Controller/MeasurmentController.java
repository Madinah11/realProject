package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.Measurement;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurment")
public class MeasurmentController {
    @Autowired
    MeasurementService measurementService;

    @PostMapping
    public Result add(@RequestBody Measurement measurement){
        Result result = measurementService.add(measurement);
        return result;
    }

    @GetMapping
    public List<Measurement> get(){
        List<Measurement> measurementList = measurementService.get();
        return measurementList;
    }

    @GetMapping("/{id}")
    public Measurement getByID(@PathVariable Integer id){
        Measurement measurement = measurementService.getById(id);
        return measurement;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = measurementService.delete(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody Measurement measurement){
        Result result = measurementService.edit(id, measurement);
        return result;
    }

}
