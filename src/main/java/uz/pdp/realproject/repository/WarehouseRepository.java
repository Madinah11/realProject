package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.realproject.entity.Measurement;
import uz.pdp.realproject.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    boolean existsByName(String name);


}
