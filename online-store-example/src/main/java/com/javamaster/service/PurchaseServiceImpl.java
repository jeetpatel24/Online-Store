package com.javamaster.service;

import com.javamaster.controller.dto.FinishPurchaseRequest;
import com.javamaster.entity.OrderEntity;
import com.javamaster.entity.ProductEntity;
import com.javamaster.entity.PurchaseItemEntity;
import com.javamaster.repository.OrderEntityRepository;
import com.javamaster.repository.PurchaseItemEntityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {

    private final ProductService productService;
    private final UserService userService;
    private final OrderEntityRepository orderEntityRepository;
    private final PurchaseItemEntityRepository purchaseItemEntityRepository;

    @Override
    public Integer finishPurchase(FinishPurchaseRequest request) {
        log.info("creating OrderEntity from request: {}", request);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setComment(request.getComment());
        orderEntity.setUserEntity(userService.findOrCreateUser(request.getUserName(),
                request.getUserSurname(), request.getEmail(), request.getPhone(), request.getAddress()));
        orderEntityRepository.save(orderEntity);

        request.getProductIdProductCount().forEach((pid, count) -> {
            ProductEntity productEntity = productService.getProductById(pid);
            PurchaseItemEntity purchaseItemEntity = new PurchaseItemEntity();

            purchaseItemEntity.setProductEntity(productEntity);
            purchaseItemEntity.setOrderEntity(orderEntity);
            purchaseItemEntity.setCount(count);
            purchaseItemEntityRepository.save(purchaseItemEntity);
        });
        return orderEntity.getId();
    }
}
