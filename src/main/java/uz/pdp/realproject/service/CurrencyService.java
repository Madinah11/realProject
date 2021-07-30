package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.realproject.entity.Currency;
import uz.pdp.realproject.entity.Measurement;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.CurrencyRepository;
import uz.pdp.realproject.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public Result add(Currency currency) {
        boolean existsByName = currencyRepository.existsByName(currency.getName());
        if (existsByName)
            return new Result("There is such a currency", false);
        currencyRepository.save(currency);
        return new Result("Currency saved", true);
    }

    public List<Currency> get() {
        List<Currency> currencyList = currencyRepository.findAll();
        return currencyList;
    }

    public Currency getById(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()) {
            Currency currency = optionalCurrency.get();
            return currency;
        }
        return new Currency();
    }

    public Result delete(Integer id) {
        try {
            currencyRepository.deleteById(id);
            return new Result("Currency deleted", true);
        } catch (Exception exception) {
            return new Result("Currency not found", false);
        }
    }

    public Result edit(Integer id, Currency currency) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent())
            return new Result("Measurement not found", false);
        Currency currency1 = optionalCurrency.get();
        boolean existsByName = currencyRepository.existsByName(currency.getName());
        if (existsByName)
            return new Result("There is such a currency", false);
        currency1.setName(currency.getName());
        currencyRepository.save(currency1);
        return new Result("Currency edited", true);
    }
}
