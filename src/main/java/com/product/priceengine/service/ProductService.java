package com.product.priceengine.service;

import com.product.priceengine.domain.Product;
import com.product.priceengine.dto.ActualPriceDTO;
import com.product.priceengine.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final OrderService orderService;

    @Inject
    public ProductService(ProductRepository productRepository, OrderService orderService) {
        this.productRepository = productRepository;
        this.orderService = orderService;
    }

    public List<ActualPriceDTO> populatePriceTable() {

        List<Product> products = productRepository.getAllProducts();
        List<ActualPriceDTO> actualPriceDTOS = new ArrayList<>();

        products.forEach(product -> {
            ActualPriceDTO actualPriceDTO = new ActualPriceDTO(product.getName());
            for (int i=0; i < 50; i++) {
                actualPriceDTO.setQuantity(i++);
                actualPriceDTO.setQuantityPrice(orderService.calculatePricePerProduct(product, i, false));
            }
            actualPriceDTOS.add(actualPriceDTO);
        });

        return actualPriceDTOS;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
