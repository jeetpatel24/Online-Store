package com.javamaster.repository;

import com.javamaster.entity.ProductEntity;
import com.javamaster.entity.PurchaseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemEntityRepository extends JpaRepository<PurchaseItemEntity, Integer> {
}
