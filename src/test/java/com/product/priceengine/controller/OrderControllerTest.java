package com.product.priceengine.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.priceengine.PriceengineApplication;
import com.product.priceengine.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PriceengineApplication.class)
public class OrderControllerTest {

    @Inject
    private OrderController orderController;

    private MockMvc mockMvc;

    @PostConstruct
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void getBill() throws Exception {
        Map<String, Integer> purchaseMap = new HashMap<>();
        purchaseMap.put("P001", 23);
        purchaseMap.put("P002", 16);

        Order order = new Order("O001", purchaseMap);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(order);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/order").content(requestBody));

        result.andExpect(status().is2xxSuccessful());
    }
}