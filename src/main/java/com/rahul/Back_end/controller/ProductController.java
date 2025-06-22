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
public class ProductController {
    productservice service;

    @Autowired      //Setter Injection
    public void setService(productservice service) {
        this.service = service;
    }

    @PostMapping("/product")                            //CREATE
    public ResponseEntity<String> AddProduct(@RequestBody Products prods){
        service.post(prods);
        return ResponseEntity.accepted().body("Successfully Saved");
    }

    @GetMapping("/products")                            //READ
    public ResponseEntity<List<Products>> getAll(){
         List<Products> prod = service.getall();
         return ResponseEntity.ok(prod);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Products> FindOne(@PathVariable int id){
        Products product = service.findone(id);
        if(product != null){
           return new ResponseEntity<>(product, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/product/{id}")                        //UPDATE
    public ResponseEntity<String> Update(@PathVariable int id,@RequestBody Products prod){
        service.update(id,prod);
        return ResponseEntity.ok("Successfully Updated Product");
    }
    @DeleteMapping("/del/{id}")                         //DELETE
    public ResponseEntity<String> Delete(@PathVariable int id){
        service.deleteprod(id);
        return ResponseEntity.ok("Product Is Deleted");
    }
}
