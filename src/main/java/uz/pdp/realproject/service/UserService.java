package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.realproject.entity.Supplier;
import uz.pdp.realproject.entity.Users;
import uz.pdp.realproject.entity.Warehouse;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.payload.UserDto;
import uz.pdp.realproject.repository.SupplierRepository;
import uz.pdp.realproject.repository.UserRepository;
import uz.pdp.realproject.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result add(UserDto userDto) {
        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("There is such a user", false);
        Set<Warehouse> warehouseList = (Set<Warehouse>) warehouseRepository.findAllById(userDto.getWarehouseId());
        Users users=new Users(null,userDto.getFirstName(),userDto.getLastName(),userDto.getPhoneNumber(),userRepository.getCodeNum()+1,userDto.getPassword(),userDto.isActive(),warehouseList);
        return new Result("User saved", true);
    }

    public List<Users> get() {
        List<Users> userRepositoryAll = userRepository.findAll();
        return userRepositoryAll;
    }

    public Users getById(Integer id) {
        Optional<Users> optionalUsers = userRepository.findById(id);
        if (optionalUsers.isPresent()) {
            Users users = optionalUsers.get();
            return users;
        }
        return new Users();
    }

    public Result delete(Integer id) {
        try {
            userRepository.deleteById(id);
            return new Result("User deleted", true);
        } catch (Exception exception) {
            return new Result("User not found", false);
        }
    }

    public Result edit(Integer id, UserDto userDto) {
        Optional<Users> optionalUsers = userRepository.findById(id);
        if (!optionalUsers.isPresent())
            return new Result("User not found", false);

        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("There is such a user", false);

        Users editingUser = optionalUsers.get();
        Set<Warehouse> warehouseSet = (Set<Warehouse>) warehouseRepository.findAllById(userDto.getWarehouseId());
        editingUser.setFirstName(userDto.getFirstName());
        editingUser.setLastName(userDto.getLastName());
        editingUser.setPhoneNumber(userDto.getPhoneNumber());
        editingUser.setPassword(userDto.getPassword());
        editingUser.setCode(userRepository.getCodeNum()+1);
        editingUser.setWarehouseSet(warehouseSet);
        userRepository.save(editingUser);
        return new Result("User edited", true);
    }
}
