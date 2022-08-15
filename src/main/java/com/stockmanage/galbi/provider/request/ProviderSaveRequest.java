package com.stockmanage.galbi.provider.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProviderSaveRequest {
    @NotNull
    private Long stockCd;
    @NotNull
    private int incomingCount;
}
