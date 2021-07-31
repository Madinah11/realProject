package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.realproject.entity.Currency;
import uz.pdp.realproject.entity.Measurement;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.CurrencyRepository;
import uz.pdp.realproject.service.CurrencyService;
import uz.pdp.realproject.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @PostMapping
    public Result add(@RequestBody Currency currency){
        Result result = currencyService.add(currency);
        return result;
    }

    @GetMapping
    public List<Currency> get(){
        List<Currency> currencies = currencyService.get();
        return currencies;
    }

    @GetMapping("/{id}")
    public Currency getByID(@PathVariable Integer id){
        Currency currency = currencyService.getById(id);
        return currency;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = currencyService.delete(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody Currency currency){
        Result result = currencyService.edit(id, currency);
        return result;
    }

}
