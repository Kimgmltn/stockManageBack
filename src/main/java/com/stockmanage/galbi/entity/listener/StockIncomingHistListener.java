package com.stockmanage.galbi.entity.listener;

import com.stockmanage.galbi.entity.Stock;
import com.stockmanage.galbi.repository.StockHistRepository;
import com.stockmanage.galbi.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class StockIncomingHistListener {

    @PostPersist
    @PostUpdate
    public void PostPersistAndUpdate(Object o){
        StockHistRepository userHistoryRepository = BeanUtils.getBean(StockHistRepository.class);
        if(o instanceof Stock){
            Stock stock = (Stock) o;

//            StockHist userHistory = StockHist.builder()
//                    .stockCd(stock)
//                    .build();

//            userHistoryRepository.save(userHistory);
        }
    }
}
