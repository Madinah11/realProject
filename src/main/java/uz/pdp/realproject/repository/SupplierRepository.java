package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.realproject.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    boolean existsByPhoneNumber(String phoneNumber);
}
