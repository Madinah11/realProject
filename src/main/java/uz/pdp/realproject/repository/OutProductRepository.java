package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.realproject.entity.InputProduct;
import uz.pdp.realproject.entity.OutputProduct;

import java.util.List;

public interface OutProductRepository extends JpaRepository<OutputProduct,Integer> {

    @Query(value = "select * from output_product order by amount desc limit 10",nativeQuery = true)
    List<OutputProduct> getBestSelledProducts();
}
