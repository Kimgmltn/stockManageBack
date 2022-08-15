package com.stockmanage.galbi.provider.service.impl;

import com.stockmanage.galbi.entity.Stock;
import com.stockmanage.galbi.provider.request.ProviderSaveRequest;
import com.stockmanage.galbi.provider.service.ProviderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProviderServiceImplTest {

    @Autowired
    private ProviderService providerService;

    @PostConstruct
    void postConstruct(){
        providerService.saveStock(Stock.builder().stockName("돼지갈비").build());
        providerService.saveStock(Stock.builder().stockName("소갈비").build());
    }

    @Test
    void saveIncomingTest(){
        Stock stock = providerService.findById(1L);
        ProviderSaveRequest request = new ProviderSaveRequest();
        request.setStockCd(stock.getStockCd());
        request.setIncomingCount(1);

        Stock stock1 = providerService.saveIncoming(request);


        Assertions.assertEquals(stock1.getTotalCount(),1);
    }

}