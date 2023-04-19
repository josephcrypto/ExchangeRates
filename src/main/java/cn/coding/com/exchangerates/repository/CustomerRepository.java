package cn.coding.com.exchangerates.repository;

import cn.coding.com.exchangerates.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Long countByCid(Long cid);
}
