package com.fsad.skill08.controller;

import com.fsad.skill08.model.Product;
import com.fsad.skill08.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product p){
        return service.addProduct(p);
    }

    @GetMapping("/category/{category}")
    public List<Product> category(@PathVariable String category){
        return service.getByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> filter(
            @RequestParam double min,
            @RequestParam double max){
        return service.getPriceRange(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> sorted(){
        return service.sortedProducts();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price){
        return service.expensiveProducts(price);
    }
}
