package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.Measurement;
import uz.pdp.realproject.entity.Warehouse;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.service.MeasurementService;
import uz.pdp.realproject.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @PostMapping
    public Result add(@RequestBody Warehouse warehouse){
        Result result = warehouseService.add(warehouse);
        return result;
    }

    @GetMapping
    public List<Warehouse> get(){
        List<Warehouse> warehouses = warehouseService.get();
        return warehouses;
    }

    @GetMapping("/{id}")
    public Warehouse getByID(@PathVariable Integer id){
        Warehouse byId = warehouseService.getById(id);
        return byId;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result delete = warehouseService.delete(id);
        return delete;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody Warehouse warehouse){
        Result result = warehouseService.edit(id,warehouse);
        return result;
    }

}
