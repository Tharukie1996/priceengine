package com.product.priceengine.controller.error;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ErrorDetail {

    @Getter
    @Setter
    private String status;

    @Getter
    @Setter
    private String details;

    public ErrorDetail() {
    }

    public ErrorDetail(String status, String details) {
        this.status = status;
        this.details = details;
    }
}

