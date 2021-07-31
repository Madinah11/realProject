package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.realproject.entity.Input;
import uz.pdp.realproject.entity.InputProduct;
import uz.pdp.realproject.entity.Product;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {

    @Query(value = "select sum(price) from input_product",nativeQuery = true)
    Double sumInputProducts();

    @Query(value = "@Query(value = \"select sum(price) from input_product\",nativeQuery = true)\n" +
            "    Double sumInputProducts();",nativeQuery = true)
    List<LocalDateTime>  expireDate();

    List<InputProduct> findAllByExpireDateLessThan(LocalDateTime expireDate);

    @Query(value = "select count(amount) from input_product",nativeQuery = true)
    Integer totalProductNum();





}
