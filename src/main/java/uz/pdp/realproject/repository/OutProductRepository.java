package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.realproject.entity.InputProduct;
import uz.pdp.realproject.entity.OutputProduct;

public interface OutProductRepository extends JpaRepository<OutputProduct,Integer> {
}
