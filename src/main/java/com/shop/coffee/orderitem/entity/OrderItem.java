package com.shop.coffee.orderitem.entity;

import com.shop.coffee.global.entity.BaseEntity;
import com.shop.coffee.item.entity.Item;
import com.shop.coffee.order.entity.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @Setter
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    @Setter
    private int quantity;

    @Column(length = 255, nullable = true)
    private String imagePath;

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

}