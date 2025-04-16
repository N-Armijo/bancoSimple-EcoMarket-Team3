package com.proyectoinregrador.bancosimpleecomarketteam3.TestService;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Detail_Order;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Order_product;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Product;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.Detail_OrderRepository;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Detail_OrderService;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.Detail_OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Detail_OrderServiceTest {

    @Mock
    private Detail_OrderRepository detail_orderRepository;

    @InjectMocks
    private Detail_OrderServiceImpl detail_orderService;

    @Test
    @DisplayName("retornaADetail_OrderAlGuardar")
    void retornaADetail_OrderAlGuardar() {

        Detail_Order detail_order = new Detail_Order();
        Product product = new Product();
        Order_product order_product = new Order_product();

        product.setId(1L);
        order_product.setId(1L);

        detail_order.setId(1L);
        detail_order.setAmmount(1222223);
        detail_order.setUnit_price(1222223);
        detail_order.setDetail_Product(product);
        detail_order.setDetail_Order(order_product);

        when(detail_orderRepository.save(detail_order)).thenReturn(detail_order);
        Detail_Order detail = detail_orderService.saveDetail_Order(detail_order);

        assertEquals(detail_order.getId(), detail.getId());
        assertEquals(detail_order.getAmmount(), detail.getAmmount());
        assertEquals(detail_order.getUnit_price(), detail.getUnit_price());
        assertEquals(detail_order.getDetail_Product().getId(), detail.getDetail_Product().getId());
        assertEquals(detail_order.getDetail_Order().getId(), detail.getDetail_Order().getId());




    }



}
