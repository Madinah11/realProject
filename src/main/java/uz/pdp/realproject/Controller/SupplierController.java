package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.Currency;
import uz.pdp.realproject.entity.Supplier;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.service.CurrencyService;
import uz.pdp.realproject.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping
    public Result add(@RequestBody Supplier supplier){
        Result result = supplierService.add(supplier);
        return result;
    }

    @GetMapping
    public List<Supplier> get(){
        List<Supplier> suppliers = supplierService.get();
        return suppliers;
    }

    @GetMapping("/{id}")
    public Supplier getByID(@PathVariable Integer id){
        Supplier supplier = supplierService.getById(id);
        return supplier;

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = supplierService.delete(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody Supplier supplier){
        Result result = supplierService.edit(id, supplier);
        return result;
    }

}
