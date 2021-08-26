package com.javamaster.controller;

import com.javamaster.controller.dto.FinishPurchaseRequest;
import com.javamaster.controller.dto.FinishPurchaseResponse;
import com.javamaster.service.PurchaseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@AllArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/finish/purchase")
    public ResponseEntity finishPurchase(@Valid @RequestBody FinishPurchaseRequest request) {
        log.info("handling finish purchase request");
        Integer orderId = purchaseService.finishPurchase(request);

        return ResponseEntity.ok(new FinishPurchaseResponse(orderId));
    }
}
