package com.product.priceengine.repository;

import com.product.priceengine.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final Product penguinEars = new Product("P001", "Penguin-ears", new BigDecimal(175), 20);
    private final Product horseshoe = new Product("P002", "HorseShoe", new BigDecimal(825), 5);

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(penguinEars);
        products.add(horseshoe);
        return products;
    }

    @Override
    public Product getProduct(String id) {
        if (id.equals(penguinEars.getId())) {
            return penguinEars;
        }
        return horseshoe;
    }

}
