package com.product.priceengine.repository;

import com.product.priceengine.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProduct(String id);
}
