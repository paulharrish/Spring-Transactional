package com.example.repo;

import com.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Transactional
    public void saveProduct(Product product){
        String sql = "INSERT INTO PRODUCT VALUES(?,?)";

        Object[] args = { product.getId(), product.getName() };

        jdbcTemplate.update(sql, args);

        System.out.println("ProductSaved");

    }
}
