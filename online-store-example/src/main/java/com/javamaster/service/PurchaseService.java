package com.javamaster.service;

import com.javamaster.controller.dto.FinishPurchaseRequest;

public interface PurchaseService {

    public Integer finishPurchase(FinishPurchaseRequest finishPurchaseRequest);
}
