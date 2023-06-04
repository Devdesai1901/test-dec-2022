package com.example.helloworldapplication;

import com.example.helloworldapplication.Entities.Product;
import com.example.helloworldapplication.Repositories.ProductRepository;
import com.example.helloworldapplication.config.ContainersEnvironment;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes =  Testcontainers.class , webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductRepositoryTest extends ContainersEnvironment {

    @Autowired
    private ProductRepository  productRepository;

    @Test
    public void When_GetProducts_Expect_EmptyList(){
        List<Product>  list = productRepository.findAll();
        assertEquals(0,list.size());
    }
}
