package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.realproject.entity.*;
import uz.pdp.realproject.payload.InputDto;
import uz.pdp.realproject.payload.OutputDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    OutputRepository outputRepository;

    public Result add(OutputDto outputDto) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Warehouse not found",false);
        Warehouse warehouse = optionalWarehouse.get();
        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (!optionalClient.isPresent())
            return new Result("Client not found",false);
        Client client = optionalClient.get();
        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("Currency not found",false);
        Currency currency = optionalCurrency.get();

        Output output=new Output(null,outputDto.getDate(),outputDto.getFactureNumber(),(outputDto.getId().toString()),warehouse,currency,client);
        outputRepository.save(output);
        return new Result("Output saved", true);
    }

    public List<Output> get() {
        List<Output> outputList = outputRepository.findAll();
        return outputList;
    }

    public Output getById(Integer id) {
        Optional<Output> outputRepositoryById = outputRepository.findById(id);
        if (outputRepositoryById.isPresent()) {
            Output output = outputRepositoryById.get();
            return output;
        }
        return new Output();
    }

    public Result delete(Integer id) {
        try {
            outputRepository.deleteById(id);
            return new Result("Output deleted", true);
        } catch (Exception exception) {
            return new Result("Output not found", false);
        }
    }

    public Result edit(Integer id,OutputDto outputDto) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (!optionalOutput.isPresent())
            return new Result("Output not found", false);
        Output editingOutput = optionalOutput.get();

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Warehouse not found",false);
        Warehouse warehouse = optionalWarehouse.get();
        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (!optionalClient.isPresent())
            return new Result("Client not found",false);
        Client client = optionalClient.get();
        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("Currency not found",false);
        Currency currency = optionalCurrency.get();

        editingOutput.setDate(outputDto.getDate());
        editingOutput.setFactureNumber(outputDto.getFactureNumber());
        editingOutput.setCurrency(currency);
        editingOutput.setClient(client);
        editingOutput.setWarehouse(warehouse);
        editingOutput.setCode(outputDto.getId().toString());
        outputRepository.save(editingOutput);
        return new Result("Output edited", true);
    }
}
