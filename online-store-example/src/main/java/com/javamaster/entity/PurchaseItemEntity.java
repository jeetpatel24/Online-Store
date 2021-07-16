package com.javamaster.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "purchase_item_table")
@Entity
@Data
public class PurchaseItemEntity extends BaseEntity{

    @Column(name = "count")
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}