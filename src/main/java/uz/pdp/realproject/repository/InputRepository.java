package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.realproject.entity.Category;
import uz.pdp.realproject.entity.Input;

public interface InputRepository extends JpaRepository<Input,Integer> {
}
