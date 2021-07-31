package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.realproject.entity.Currency;
import uz.pdp.realproject.entity.Supplier;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Result add(Supplier supplier) {
        boolean existsByPhoneNumber = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("There is such a phone number of supplier", false);
        supplierRepository.save(supplier);
        return new Result("Currency saved", true);
    }

    public List<Supplier> get() {
        List<Supplier> supplierList = supplierRepository.findAll();
        return supplierList;
    }

    public Supplier getById(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            Supplier supplier = optionalSupplier.get();
            return supplier;
        }
        return new Supplier();
    }

    public Result delete(Integer id) {
        try {
            supplierRepository.deleteById(id);
            return new Result("Supplier deleted", true);
        } catch (Exception exception) {
            return new Result("Supplier not found", false);
        }
    }

    public Result edit(Integer id, Supplier supplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent())
            return new Result("Supplier not found", false);
        Supplier supplier1 = optionalSupplier.get();
        boolean existsByPhoneNumber = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("There is such a phone number of supplier", false);
        supplier1.setName(supplier.getName());
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepository.save(supplier1);
        return new Result("Supplier edited", true);
    }
}
