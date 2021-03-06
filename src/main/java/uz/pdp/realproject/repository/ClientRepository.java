package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.realproject.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
