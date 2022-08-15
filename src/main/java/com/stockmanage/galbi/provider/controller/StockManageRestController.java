package com.stockmanage.galbi.provider.controller;

import com.stockmanage.galbi.provider.request.ProviderSaveRequest;
import com.stockmanage.galbi.provider.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/provider")
public class StockManageRestController {

    private final ProviderService providerService;

    @PatchMapping("/provide")
    @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
    public ResponseEntity saveIncoming(@RequestBody @Valid ProviderSaveRequest request){
        return ResponseEntity.ok(providerService.saveIncoming(request));
    }

    @GetMapping("/stocks")
    @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
    public ResponseEntity findCodes(){
        return ResponseEntity.ok(providerService.findAll());
    }

    @PostMapping("/{stockName}")
    @CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
    public ResponseEntity saveStock(@PathVariable String stockName){
        return ResponseEntity.ok(providerService.saveStockByStockName(stockName));
    }
}
