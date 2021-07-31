package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.Client;
import uz.pdp.realproject.entity.Measurement;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.service.ClientService;
import uz.pdp.realproject.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping
    public Result add(@RequestBody Client client){
        Result result = clientService.add(client);
        return result;
    }

    @GetMapping
    public List<Client> get(){
        List<Client> clients = clientService.get();
        return clients;
    }

    @GetMapping("/{id}")
    public Client getByID(@PathVariable Integer id){
        Client byId = clientService.getById(id);
        return byId;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = clientService.delete(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody Client client){
        Result result = clientService.edit(id,client);
        return result;
    }

}
