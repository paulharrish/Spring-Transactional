package com.example.service;

import com.example.model.Product;
import com.example.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    @Transactional //Connection Starts here
    public void saveProductnfo() {

        for (int i = 1; i <= 10; i++) {
            Product product = new Product(i, "Test product" + i);
            productRepo.saveProduct(product);

        }//either commit or rollback here.
        //close
    }

}
