package uz.pdp.realproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.realproject.entity.Client;
import uz.pdp.realproject.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {

    boolean existsByPhoneNumber(String phoneNumber);

    @Query(value = "select max(code) from users",nativeQuery = true)
    String getCodeNum();
}
