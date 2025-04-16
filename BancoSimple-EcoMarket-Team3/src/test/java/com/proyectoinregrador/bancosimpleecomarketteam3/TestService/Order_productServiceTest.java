package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;


import com.proyectoinregrador.bancosimpleecomarketteam3.model.Bank_account;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Order_product;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Order_productRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Order_productServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Order_productServiceTest {

    @Mock
    private Order_productRepository order_productRepository;

    @InjectMocks
    private Order_productServiceImpl order_productService;

    @Test
    @DisplayName("retornaOrder_productAlGuardar")
    public void retornaOrder_productAlGuardar() {

        Order_product order_product = new Order_product();
        User user = new User();
        Bank_account bankAccount = new Bank_account();

        order_product.setId(1L);
        order_product.setDirection_alias("direction_alias");
        order_product.setDateP(LocalDate.now());
        order_product.setTotal(50000);
        order_product.setState("state");
        order_product.setOrder_User(user);
        order_product.setOrder_Account(bankAccount);

        when(order_productRepository.save(order_product)).thenReturn(order_product);
        Order_product order = order_productService.saveOrder(order_product);

        assertEquals(order_product.getId(), order.getId());
        assertEquals(order_product.getDirection_alias(), order.getDirection_alias());
        assertEquals(order_product.getDateP(), order.getDateP());
        assertEquals(order_product.getTotal(), order.getTotal());
        assertEquals(order_product.getState(), order.getState());
        assertEquals(order_product.getOrder_User().getId(), order.getOrder_User().getId());
        assertEquals(order_product.getOrder_Account().getId(), order.getOrder_Account().getId());



    }



}
