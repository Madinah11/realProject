package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.realproject.entity.Input;
import uz.pdp.realproject.entity.InputProduct;

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
}
