package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Detail_Order;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Order_product;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Detail_OrderTest {

    @Test
    void cuandoCreamosUnDetail_OrderConDatosDebeMantenerValoresAsignados() {
        Detail_Order detailOrder = new Detail_Order();

        Product product = new Product();
        product.setId(2L);

        Order_product order = new Order_product();
        order.setId(3L);

        detailOrder.setId(1L);
        detailOrder.setAmmount(5);
        detailOrder.setUnit_price(1500);
        detailOrder.setDetail_Product(product);
        detailOrder.setDetail_Order(order);

        assertThat(detailOrder)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("ammount", 5)
                .hasFieldOrPropertyWithValue("unit_price", 1500)
                .hasFieldOrPropertyWithValue("detail_Product", product)
                .hasFieldOrPropertyWithValue("detail_Order", order);
    }
}
