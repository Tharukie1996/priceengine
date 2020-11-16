package com.product.priceengine.controller;

import com.product.priceengine.PriceengineApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PriceengineApplication.class)
public class ProductControllerTest {

    @Inject
    ProductController productController;

    private MockMvc mockMvc;

    @PostConstruct
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void populatePriceTable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/priceDetails")).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")).andExpect(status().is2xxSuccessful());
    }
}