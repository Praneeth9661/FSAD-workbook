package com.fsad.skill08.service;

import com.fsad.skill08.model.Product;
import com.fsad.skill08.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product addProduct(Product p){
        return repo.save(p);
    }

    public List<Product> getByCategory(String category){
        return repo.findByCategory(category);
    }

    public List<Product> getPriceRange(double min, double max){
        return repo.findByPriceBetween(min, max);
    }

    public List<Product> sortedProducts(){
        return repo.sortProductsByPrice();
    }

    public List<Product> expensiveProducts(double price){
        return repo.findExpensiveProducts(price);
    }
}
