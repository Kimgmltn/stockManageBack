package com.stockmanage.galbi.provider.service;

import com.stockmanage.galbi.entity.Stock;
import com.stockmanage.galbi.provider.request.ProviderSaveRequest;

import java.util.List;

public interface ProviderService {

    Stock saveIncoming(ProviderSaveRequest request);

    Stock saveStock(Stock stock);

    Stock findById(Long id);

    List<Stock> findAll();

    Stock saveStockByStockName(String name);

}
