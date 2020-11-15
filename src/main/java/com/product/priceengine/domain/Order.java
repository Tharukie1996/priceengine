package com.product.priceengine.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@ToString
public class Order {

    private String id;
    private BigDecimal price;
    private Map<String, Integer> purchaseList;
}
