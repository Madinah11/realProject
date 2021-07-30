package uz.pdp.realproject.payload;

import lombok.Data;
import java.util.Set;

@Data
public class UserDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String code;

    private String password;

    private Set<Integer> warehouseId;

    private boolean active = true;
}
