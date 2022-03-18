package com.example.easyrental;


import com.example.easyrental.controller.BookingController;
import com.example.easyrental.dao.BookingRepository;
import com.example.easyrental.dao.ProductRepository;
import com.example.easyrental.model.Booking;
import com.example.easyrental.model.BookingStatus;
import com.example.easyrental.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingTests {

 @Autowired
 BookingController bookingController;

 @Mock
 ProductRepository productRepository;

 @Mock
 BookingRepository bookingRepository;

 @Mock
 BookingStatus bookingStatus;


 @Before
 public void setUp() {
  Product alex = new Product();

 }

 @Test
 public void checkoutTest(){
  Map<String, Object>  payload= new HashMap<>();
  Product product= new Product();
  product.setId(Long.valueOf("1"));
  when(productRepository.findById(any())).thenReturn(Optional.of(product));
  doNothing().when(productRepository).updateIsAvailability(anyBoolean(),product.getId());
  doNothing().when(productRepository.findById(any()));
  payload.put("productId",null);
  bookingController.checkout(payload);
 }

}
