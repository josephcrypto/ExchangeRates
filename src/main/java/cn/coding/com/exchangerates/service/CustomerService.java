package cn.coding.com.exchangerates.service;

import cn.coding.com.exchangerates.exception.CustomerNotFoundException;
import cn.coding.com.exchangerates.model.Customer;
import cn.coding.com.exchangerates.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> customerList() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer getByCid(Long cid) throws CustomerNotFoundException {
        Optional<Customer> result = customerRepository.findById(cid);
        if (result.isPresent()) {
            return result.get();
        }
        throw new CustomerNotFoundException("Could not find Customer with ID " + cid);
    }

    public void deleteByCid(Long cid) throws CustomerNotFoundException {
        Long count = customerRepository.countByCid(cid);
        if (count == null || count == 0 ) {
            throw new CustomerNotFoundException("Could not find any Customer with ID " + cid);
        }
        customerRepository.deleteById(cid);
    }
}
