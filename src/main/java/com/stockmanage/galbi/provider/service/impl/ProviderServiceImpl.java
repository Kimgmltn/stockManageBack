package com.stockmanage.galbi.provider.service.impl;

import com.stockmanage.galbi.entity.Stock;
import com.stockmanage.galbi.entity.StockHist;
import com.stockmanage.galbi.provider.request.ProviderSaveRequest;
import com.stockmanage.galbi.provider.service.ProviderService;
import com.stockmanage.galbi.repository.StockHistRepository;
import com.stockmanage.galbi.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final StockRepository stockRepository;
    private final StockHistRepository stockHistRepository;

    @Override
    @Transactional
    public Stock saveIncoming(ProviderSaveRequest request) {
        Stock stock = stockRepository.findById(request.getStockCd()).get();
        stock.setTotalCount(stock.getTotalCount() + request.getIncomingCount());

        Stock stock1 = this.saveStock(stock);
//        stockRepository.save(stock);

        StockHist build = StockHist.builder()
                .stock(stock1)
                .incomingCount(request.getIncomingCount())
                .build();
        stockHistRepository.save(build);

        return stock;
    }

    @Override
    public Stock saveStock(Stock stock){
        return stockRepository.save(stock);
    }

    @Override
    public Stock saveStockByStockName(String stockName){
        return this.saveStock(Stock.builder().stockName(stockName).build());
    }

    @Override
    public Stock findById(Long id) {
        return stockRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

}
