package com.example.easyrental;

import com.example.easyrental.controller.BookingController;
import com.example.easyrental.controller.ProductController;
import com.example.easyrental.controller.UserController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EasyRentalApplicationTests {

    @Autowired
    BookingController bookingController;

    @Autowired
    ProductController productController;

    @Autowired
    UserController userController;

    @Test
    void contextLoads() throws Exception {
        //Assert.assertNotNull(bookingController);
        //Assert.assertNotNull(productController);
       // Assert.assertNotNull(userController);
    }

}
