package com.example.easyrental;


import com.example.easyrental.controller.BookingController;
import com.example.easyrental.dao.BookingRepository;
import com.example.easyrental.dao.ProductRepository;
import com.example.easyrental.model.Booking;
import com.example.easyrental.model.BookingStatus;
import com.example.easyrental.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BookingTests {

 @Autowired
 BookingController bookingController;

 @Mock
 ProductRepository productRepository;

 @Mock
 BookingRepository bookingRepository;


 @Before
 public void setUp() {
  MockitoAnnotations.initMocks(this);
 }

 @Test
 public void checkoutFailedTest(){
  Map<String, Object> payload= new HashMap<>();
  payload.put("borrowerUserId","123");
  payload.put("productId","1");
  Product product= new Product();
  product.setId(Long.valueOf("1"));
  when(productRepository.findById(any())).thenReturn(null);
  doNothing().when(productRepository).updateIsAvailability(anyBoolean(),eq(product.getId()));
  String message = bookingController.checkout(payload);
  Assert.assertEquals("CheckoutFailed",message);
 }

 @Test
 public void approveTransactionTest(){
  Booking booking = new Booking();
  booking.setId(Long.valueOf("1"));
  when(bookingRepository.getById(any())).thenReturn(booking);
  doNothing().when(bookingRepository).updateBookingStatus(any(),eq(booking.getId()));
  String message=bookingController.approveTransaction(Long.valueOf("123"));
  Assert.assertEquals("Successful",message);
 }

 @Test
 public void rejectTransactionTest(){
  Booking booking = new Booking();
  booking.setId(Long.valueOf("1"));
  Exception e= new RuntimeException();
  doThrow(e).when(bookingRepository).getById(any());
  String message=bookingController.rejectTransaction(Long.valueOf("123"));
  Assert.assertEquals("Failed",message);
 }

}
