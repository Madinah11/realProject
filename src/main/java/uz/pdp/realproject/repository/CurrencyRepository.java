package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.realproject.entity.Currency;
import uz.pdp.realproject.entity.Measurement;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    boolean existsByName(String name);


}
