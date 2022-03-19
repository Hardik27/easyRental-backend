package com.example.easyrental.controller;

import com.example.easyrental.dao.ProductRepository;
import com.example.easyrental.dao.UserRepository;
import com.example.easyrental.model.Product;
import com.example.easyrental.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class ProductController {
    final ProductRepository productRepository;
    final UserRepository userRepository;

    public ProductController(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(
            value = "/registerProduct",
            method = RequestMethod.POST)
    public String registerProduct(@RequestBody Map<String, Object> payLoad) {
        try{
            String title = (String) payLoad.get(Product.FIELD_TITLE);
            String description = (String) payLoad.get(Product.FIELD_DESCRIPTION);
            String price = (String) payLoad.get(Product.FIELD_PRICE);
            List<String> tags = Stream.of(payLoad.get(Product.FIELD_TAGS))
                    .map(object -> Objects.toString(object, null))
                    .collect(Collectors.toList());
            List<String> images = Stream.of(payLoad.get(Product.FIELD_IMAGES))
                    .map(object -> Objects.toString(object, null))
                    .collect(Collectors.toList());
            String productMetaData = (String) payLoad.get(Product.FIELD_PRODUCT_METADATA);
            boolean availability = true;
            String email = (String) payLoad.get(User.FIELD_EMAIL);
            User currentUser = userRepository.findByEmail(email);
            Long userId = currentUser.getId();
            if (title == null) {
                System.out.println("Product with title doesn't exist");
                return "IncorrectDetails";
            }
            Product product = new Product(title, description, userId, price, tags, images, productMetaData, availability);
            productRepository.save(product);
            return "Successful";
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return "Failed";
        }

    }
}
