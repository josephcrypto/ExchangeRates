package cn.coding.com.exchangerates.repository;

import cn.coding.com.exchangerates.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    public Long countById(Long id);
    }
