package com.misiontic_DW5_G5.products_ms.controller;

import com.misiontic_DW5_G5.products_ms.model.Product;
import com.misiontic_DW5_G5.products_ms.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    ProductRepository productRepo;
//read
    @RequestMapping("/products")
    @ResponseBody
    public ResponseEntity<List<Product>> getAllItems(){
        List<Product> products =  productRepo.findAll();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    @ResponseBody
    public ResponseEntity<Product> getProduct(@PathVariable int productId){
        Optional<Product> product = productRepo.findById(productId);
        return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
    }
//create
    @PostMapping(value = "/add",consumes = {"application/json"},produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Product> addProduct(@RequestBody Product product, UriComponentsBuilder builder){
        productRepo.save(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/addProduct/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<Product>(headers, HttpStatus.CREATED);
    }

//Update
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        if(product != null){
            productRepo.save(product);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

//Delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        Optional<Product> product = productRepo.findById(id);
        productRepo.delete(product.get());
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
