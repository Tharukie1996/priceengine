package com.product.priceengine.service;

import com.product.priceengine.domain.Order;
import com.product.priceengine.domain.Product;
import com.product.priceengine.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 */

@Service
public class OrderService {

    private final ProductRepository productRepository;

    @Inject
    public OrderService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Order getOrderPrice(Order order) {

        BigDecimal total = new BigDecimal(0);
        for (String itemId: order.getPurchaseList().keySet()) {
            Product product = productRepository.getProduct(itemId);
            total = total.add(calculatePricePerProduct(product, order.getPurchaseList().get(itemId), true));
        }

        order.setPrice(total);
        //save order to db
        return order;
    }

    public BigDecimal calculatePricePerProduct(Product product, int amount, boolean withDiscount) {

        int amountOfCartons = amount/product.getUnitsPerCarton();
        int amountOfUnits = amount%product.getUnitsPerCarton();

        BigDecimal cartonPrice = new BigDecimal(0);

        if (withDiscount) {
            cartonPrice = 2 < amountOfCartons ? BigDecimal.valueOf(amountOfCartons).multiply(product.getCartonPrice()).multiply(new BigDecimal("0.9"))
                    : BigDecimal.valueOf(amountOfCartons).multiply(product.getCartonPrice());
        }
        else {
            cartonPrice = BigDecimal.valueOf(amountOfCartons).multiply(product.getCartonPrice());
        }

        return cartonPrice.add(BigDecimal.valueOf(amountOfUnits).multiply(product.getCartonPrice())
                .multiply(BigDecimal.valueOf(1.3)).divide(BigDecimal.valueOf(product.getUnitsPerCarton()), 2, RoundingMode.HALF_UP));
    }
}
