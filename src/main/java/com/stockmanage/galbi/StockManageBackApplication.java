package com.stockmanage.galbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StockManageBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockManageBackApplication.class, args);
    }

}
