package com.stockmanage.galbi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name="tbl_stock_hist")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class StockHist extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockHistId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_cd")
    private Stock stock;
    private int incomingCount;
    private int outgoingCount;

}
