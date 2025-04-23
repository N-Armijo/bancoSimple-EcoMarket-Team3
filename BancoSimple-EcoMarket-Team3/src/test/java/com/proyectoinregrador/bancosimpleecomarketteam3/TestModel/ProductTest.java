package com.proyectoinregrador.bancosimpleecomarketteam3.TestModel;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.Categories;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Product;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {

    @Test
    void cuandoCreamosUnProductoConDatosDebeMantenerLosValoresAsignados() {

        Product product = new Product();
        User user = new User();
        user.setId(1L);

        Categories category = new Categories();
        category.setId(2L);
        category.setNombre("Ropa");
        category.setDescription("Prendas de vestir");

        product.setId(3L);
        product.setProduct_name("Poleron");
        product.setDescription("Poleron de pluma color azul");
        product.setPrice(10000);
        product.setStock(30);
        product.setProduct_User(user);
        product.setProduct_Categories(List.of(category));

        assertThat(product)
                .hasFieldOrPropertyWithValue("id", 3L)
                .hasFieldOrPropertyWithValue("product_name", "Poleron")
                .hasFieldOrPropertyWithValue("description", "Poleron de pluma color azul")
                .hasFieldOrPropertyWithValue("price", 10000)
                .hasFieldOrPropertyWithValue("stock", 30)
                .hasFieldOrPropertyWithValue("product_User", user)
                .hasFieldOrPropertyWithValue("productCategories", List.of(category));
    }
}

