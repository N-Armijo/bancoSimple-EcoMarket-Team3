package com.proyectoinregrador.bancosimpleecomarketteam3.api;

import com.proyectoinregrador.bancosimpleecomarketteam3.dto.ProductDTO;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Categories;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.Product;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import com.proyectoinregrador.bancosimpleecomarketteam3.service.ProductServiceImpl;
import com.proyectoinregrador.bancosimpleecomarketteam3.storage.GoogleCloudStorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductRestController {

    private final ProductServiceImpl productService;
    private final GoogleCloudStorageService storageService;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAllProduct());
    }

    @Operation(summary = "Este endpoint permite crear un nuevo producto", description = "Se crea un nuevo producto a través de un DTO y recibe también, una imagen como archivo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto creado exitosamente",
                    content = @Content(schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "400", description = "Datos del producto son inválidos")
    })

    @PostMapping(value = "/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductDTO> saveProduct(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "DTO de Producto que será creado",
            required = true,
            content = @Content(schema = @Schema(implementation = ProductDTO.class))
    )
    @RequestPart("product") ProductDTO newProduct,
    @RequestPart("img")MultipartFile img) throws IOException{
        String imageUrl = null;
        if (!img.isEmpty()) {
            imageUrl = storageService.uploadImagenProducto(img);
    }
    Product product = toModel(newProduct);

    product.setImg_Url(imageUrl);
    newProduct.setImagen(imageUrl);
    productService.saveProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>("The Product was deleted",HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product productSelected = productService.findById(product.getId());
        if(productSelected != null){
            return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Product toModel(ProductDTO nuevoProducto) {
        Product producto = new Product();
        User user = new User();
        Categories categories = new Categories();
        List<Long> categoriesList = nuevoProducto.getCategories_id();
        List<Categories> newList = new java.util.ArrayList<>();
        for (Long i: categoriesList){
            categories.setId(i);
            newList.add(categories);
        }
        user.setId(nuevoProducto.getUser_id());
        producto.setStock(nuevoProducto.getStock());
        producto.setPrice(nuevoProducto.getPrice());
        producto.setProduct_name(nuevoProducto.getProduct_name());
        producto.setDescription(nuevoProducto.getDescription());

        producto.setProduct_User(user);
        producto.setProduct_Categories(newList);
        return producto;
    }

}
