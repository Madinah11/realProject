package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.realproject.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
