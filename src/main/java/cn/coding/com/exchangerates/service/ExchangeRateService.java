package cn.coding.com.exchangerates.service;

import cn.coding.com.exchangerates.model.ExchangeRate;
import cn.coding.com.exchangerates.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository repository;

    public List<ExchangeRate> exchangeRates() {
        return (List<ExchangeRate>) repository.findAll();
    }

    public void save(ExchangeRate exchangeRate) {
        repository.save(exchangeRate);
    }

    public ExchangeRate getById(Long id) throws Exception {
        Optional<ExchangeRate> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new Exception("Can not find ExchangeRate with ID " + id);
    }

    public void deleteById(Long id) throws Exception {
        Long count = repository.countById(id);
        if (count == null || count == 0 ) {
            throw new Exception("Could not find any ExchangeRate with ID " + id);
        }
        repository.deleteById(id);
    }
}
