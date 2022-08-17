package com.stockmanage.galbi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_stock", schema = "galbi")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@EntityListeners(value = {StockIncomingHistListener.class})
public class Stock extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockCd;
    private String stockName;
    private int totalCount;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="stock_cd", insertable = false, updatable = false)
    @ToString.Exclude
    private List<StockHist> stockHists = new ArrayList<>();

}

