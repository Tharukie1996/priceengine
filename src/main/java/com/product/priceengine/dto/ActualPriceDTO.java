package com.product.priceengine.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ActualPriceDTO {

    private String productName;
    private int quantity;
    private BigDecimal quantityPrice;

    public ActualPriceDTO() {
    }

    public ActualPriceDTO(String productName) {
        this.productName = productName;
    }

    public ActualPriceDTO(String productName, int quantity, BigDecimal quantityPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.quantityPrice = quantityPrice;
    }
}
