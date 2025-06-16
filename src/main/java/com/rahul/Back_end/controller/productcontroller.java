package com.rahul.Back_end.controller;

import com.rahul.Back_end.model.Products;
import com.rahul.Back_end.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class productcontroller {
    productservice service;
    Products products;

    @Autowired      //Setter Injection
    public void setService(productservice service) {
        this.service = service;
    }

    @PostMapping("/product")                            //CREATE
    public void Add_product(@RequestBody Products prods){
        service.post(prods);
    }

    @GetMapping("/products")                            //READ
    public List<Products> get_all(){
        return service.getall();
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Products> findone(@PathVariable int id){
        Products product = service.findone(id);
        if(product != null){
           return new ResponseEntity<>(product, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/product/{id}")                        //UPDATE
    public void Update(@PathVariable int id,@RequestBody Products prod){
        service.update(id,prod);
    }
    @DeleteMapping("/del/{id}")                         //DELETE
    public void Delete(@PathVariable int id){
        service.deleteprod(id);
    }
}
