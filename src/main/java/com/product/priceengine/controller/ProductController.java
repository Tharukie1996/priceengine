package com.product.priceengine.controller;

import com.product.priceengine.domain.Product;
import com.product.priceengine.dto.ActualPriceDTO;
import com.product.priceengine.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/vi")
public class ProductController {

    private final ProductService  productService;

    @Inject
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/priceDetails")
    public ResponseEntity<List<ActualPriceDTO>> populatePriceTable() {
        return new ResponseEntity<>(productService.populatePriceTable(), HttpStatus.OK);
    }

    @GetMapping("/products")
    public  ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
