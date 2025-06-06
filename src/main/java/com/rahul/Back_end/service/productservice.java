package com.rahul.Back_end.service;

import com.rahul.Back_end.model.Products;
import com.rahul.Back_end.repositry.Productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class productservice {
    Productrepo repo;
    Products products;
    @Autowired
    public void setRepo(Productrepo repo) {
        this.repo = repo;
    }
    @Autowired
    public void setProducts(Products products) {
        this.products = products;
    }

    public List<Products> getall() {
        return repo.findAll();
    }
    public void post(Products prod) {
        repo.save(prod);
    }

    public void update(int id , Products prod) {
        Optional<Products> optionalProduct = repo.findById(id);

        if (optionalProduct.isPresent()) {
            Products existingProduct = optionalProduct.get();
            // Update fields
            existingProduct.setName(prod.getName());
            existingProduct.setDescription(prod.getDescription());
            existingProduct.setBrand(prod.getBrand());
            existingProduct.setPrice(prod.getPrice());

            // Save updated product
            Products savedProduct = repo.save(existingProduct);
        }
    }


    public void deleteprod(int id) {
        repo.deleteById(id);
    }

    public Products find1(int id) {
         return repo.findById(id).orElse(new Products());
    }
}
