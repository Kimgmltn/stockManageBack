package com.stockmanage.galbi.repository;

import com.stockmanage.galbi.entity.Stock;
import com.stockmanage.galbi.entity.StockHist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockHistRepository extends JpaRepository<StockHist, Stock> {
}
