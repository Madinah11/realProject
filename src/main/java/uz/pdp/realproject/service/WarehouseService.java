package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.realproject.entity.Measurement;
import uz.pdp.realproject.entity.Warehouse;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.MeasurementRepository;
import uz.pdp.realproject.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result add( Warehouse warehouse){
        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName)
            return new Result("There is such a warehouse",false);
        warehouseRepository.save(warehouse);
        return new Result("Warehouse saved",true);
    }

    public List<Warehouse> get(){
        List<Warehouse> warehouseList = warehouseRepository.findAll();
        return warehouseList;
    }

    public Warehouse getById(Integer id){
        Optional<Warehouse> warehouseRepositoryById = warehouseRepository.findById(id);
        if (warehouseRepositoryById.isPresent()){
            Warehouse warehouse = warehouseRepositoryById.get();
            return warehouse;
        }
        return new Warehouse();
    }

    public Result delete(Integer id){
       try {
           warehouseRepository.deleteById(id);
           return new Result("Warehouse deleted", true);
       }catch (Exception exception){
           return new Result("Warehouse not found", false);
       }
    }

    public Result edit(Integer id,Warehouse warehouse){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent())
            return new Result("Warehouse not found",false);
        Warehouse warehouse1 = optionalWarehouse.get();
        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName)
            return new Result("There is such a warehouse",false);
        warehouse1.setName(warehouse.getName());
        warehouseRepository.save(warehouse1);
        return new Result("Warehouse edited",true);



    }
}
