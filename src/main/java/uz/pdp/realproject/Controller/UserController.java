package uz.pdp.realproject.Controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.Supplier;
import uz.pdp.realproject.entity.Users;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.payload.UserDto;
import uz.pdp.realproject.repository.UserRepository;
import uz.pdp.realproject.repository.WarehouseRepository;
import uz.pdp.realproject.service.SupplierService;
import uz.pdp.realproject.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    WarehouseRepository warehouseRepository;

    @PostMapping
    public Result add(@RequestBody UserDto userDto){
        Result result = userService.add(userDto);
        return result;
    }

    @GetMapping
    public List<Users> get(){
        List<Users> users = userService.get();
        return users;
    }

    @GetMapping("/{id}")
    public Users getByID(@PathVariable Integer id){
        Users usereById = userService.getById(id);
        return usereById;

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = userService.delete(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody UserDto userDto){
        Result result = userService.edit(id, userDto);
        return result;
    }

}
