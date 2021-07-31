package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.realproject.entity.Client;
import uz.pdp.realproject.entity.Measurement;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.ClientRepository;
import uz.pdp.realproject.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Result add( Client client){
        boolean existsByName = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (existsByName)
            return new Result("There is such a phone number",false);
        clientRepository.save(client);
        return new Result("Client saved",true);
    }

    public List<Client> get(){
        List<Client> clientList = clientRepository.findAll();
        return clientList;
    }

    public Client getById(Integer id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            Client client = optionalClient.get();
            return client;
        }
        return new Client();
    }

    public Result delete(Integer id){
       try {
           clientRepository.deleteById(id);
           return new Result("Client deleted", true);
       }catch (Exception exception){
           return new Result("Client not found", false);
       }
    }

    public Result edit(Integer id,Client client){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent())
            return new Result("Client not found",false);
        Client client1 = optionalClient.get();
        boolean existsByName = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (existsByName)
            return new Result("There is such a phone number",false);
        client1.setName(client.getName());
        client1.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(client1);
        return new Result("Client edited",true);



    }
}
