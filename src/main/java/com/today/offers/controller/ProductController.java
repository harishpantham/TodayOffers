package com.today.offers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.today.offers.dto.ProductDTO;
import com.today.offers.model.Product;
import com.today.offers.serviceI.ProductServiceI;
import com.today.offers.utils.OffersResponse;

@RestController
public class ProductController {

    @Autowired
    ProductServiceI productServiceI;

    @GetMapping("/products")
    public OffersResponse  getAllProducts() {
        return productServiceI.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public OffersResponse  getProductById(@PathVariable Long productId) {
        return productServiceI.getProductById(productId);
    }

    @PostMapping("/products")
    public OffersResponse saveProduct(@RequestBody ProductDTO productDTO) {
        return productServiceI.saveProduct(productDTO);
    }

    @PutMapping("/products/{productId}")
    public OffersResponse updateProduct(@RequestBody ProductDTO productDTO) {
        return productServiceI.updateProduct(productDTO);
    }

    @DeleteMapping("/products/{productId}")
    public OffersResponse deleteProduct(@PathVariable Long productId) {
        return productServiceI.deleteProduct(productId);
    }
}
