package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.realproject.entity.Product;
import uz.pdp.realproject.entity.Users;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    boolean existsByName(String name);


}
