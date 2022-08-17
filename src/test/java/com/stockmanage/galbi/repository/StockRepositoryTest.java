package com.stockmanage.galbi.repository;

import com.stockmanage.galbi.entity.Stock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootTest
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StockRepositoryTest {

    @Autowired
    private StockRepository stockRepository;

    @PostConstruct
    void makeStock(){
        Stock stock1 = new Stock();
        stock1.setStockName("돼지갈비");

        stockRepository.save(stock1);

        Stock stock2 = new Stock();
        stock2.setStockName("소갈비");

        stockRepository.save(stock2);
    }

    @Test
    void save(){
        Stock stock = new Stock();
        stock.setStockName("돼지갈비");

        stockRepository.save(stock);

        List<Stock> all = stockRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void update(){
        Stock stock = stockRepository.findById(1L).get();
        stock.setStockName("돼지갈비 111");

        stockRepository.save(stock);
    }


}