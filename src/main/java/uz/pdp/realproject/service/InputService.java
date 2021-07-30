package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.realproject.entity.*;
import uz.pdp.realproject.payload.InputDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    InputRepository inputRepository;

    public Result add(InputDto inputDto) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Warehouse not found",false);
        Warehouse warehouse = optionalWarehouse.get();
        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (!optionalSupplier.isPresent())
            return new Result("Supplier not found",false);
        Supplier supplier = optionalSupplier.get();
        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("Currency not found",false);
        Currency currency = optionalCurrency.get();

        Input input=new Input(null,inputDto.getDate(),inputDto.getFactureNumber(),(inputDto.getId().toString()),warehouse,currency,supplier);
        inputRepository.save(input);
        return new Result("Input saved", true);
    }

    public List<Input> get() {
        List<Input> inputAll = inputRepository.findAll();
        return inputAll;
    }

    public Input getById(Integer id) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (optionalInput.isPresent()) {
            Input input = optionalInput.get();
            return input;
        }
        return new Input();
    }

    public Result delete(Integer id) {
        try {
            inputRepository.deleteById(id);
            return new Result("Input deleted", true);
        } catch (Exception exception) {
            return new Result("Input not found", false);
        }
    }

    public Result edit(Integer id,InputDto inputDto) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent())
            return new Result("Input not found", false);
        Input editingInput = optionalInput.get();

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Warehouse not found",false);
        Warehouse warehouse = optionalWarehouse.get();
        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (!optionalSupplier.isPresent())
            return new Result("Supplier not found",false);
        Supplier supplier = optionalSupplier.get();
        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("Currency not found",false);
        Currency currency = optionalCurrency.get();

        editingInput.setDate(inputDto.getDate());
        editingInput.setFactureNumber(inputDto.getFactureNumber());
        editingInput.setCurrency(currency);
        editingInput.setSupplier(supplier);
        editingInput.setWarehouse(warehouse);
        editingInput.setCode(inputDto.getId().toString());
        inputRepository.save(editingInput);
        return new Result("Input edited", true);
    }
}
