package com.product.priceengine.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Product {

    private String id;
    private String name;
    private BigDecimal cartonPrice;
    private int unitsPerCarton;

    public Product() {
    }

    public Product(String id, String name, BigDecimal cartonPrice, int unitsPerCarton) {
        this.id = id;
        this.name = name;
        this.cartonPrice = cartonPrice;
        this.unitsPerCarton = unitsPerCarton;
    }
}
