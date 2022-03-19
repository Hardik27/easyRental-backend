package com.example.easyrental.controller;

import com.example.easyrental.dao.BookingRepository;
import com.example.easyrental.dao.ProductRepository;
import com.example.easyrental.dao.UserRepository;
import com.example.easyrental.model.Booking;
import com.example.easyrental.model.BookingStatus;
import com.example.easyrental.model.Product;
import com.example.easyrental.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class BookingController {

    final ProductRepository productRepository;
    final UserRepository userRepository;
    final BookingRepository bookingRepository;

    public BookingController(ProductRepository productRepository, UserRepository userRepository, BookingRepository bookingRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(
            value = "/checkout",
            method = RequestMethod.POST)
    public String checkout(@RequestBody Map<String, Object> payLoad) {
        try {
            Long borrowerUserId = Long.valueOf((String) payLoad.get(Booking.FIELD_BORROWER_USER_ID));
            Long productId = Long.valueOf((String) payLoad.get(Booking.FIELD_PRODUCT_ID));
            Product product = productRepository.findById(productId).orElse(null);
            if (product == null)
                return "CheckoutFailed";
            Long ownerUserId = product.getUserId();
            String productName = product.getTitle();
            BookingStatus status = BookingStatus.RESERVED;
            long startTime = Long.parseLong((String) payLoad.get(Booking.FIELD_START_TIME));
            long endTime = Long.parseLong((String) payLoad.get(Booking.FIELD_END_TIME));
            long total_price = Long.parseLong((String) payLoad.get(Booking.FIELD_TOTAL_PRICE));
            Booking booking = new Booking(productName, ownerUserId, borrowerUserId, productId, status, startTime, endTime, total_price);
            productRepository.updateIsAvailability(Boolean.FALSE, booking.getProductId());
            bookingRepository.save(booking);
            System.out.println("Saved booking");
            return "CheckoutSuccessful";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Failed";
        }
    }

    @RequestMapping(
            value = "/fetchAllProducts",
            method = RequestMethod.GET)
    public Map<Long, String> fetchAllProducts(@RequestBody Map<String, Object> payLoad) {
        String email = (String) payLoad.get(User.FIELD_EMAIL);
        User currUser = userRepository.findByEmail(email);
        List<Booking> ownerBookings = bookingRepository.findBookingByOwnerUserId(currUser.getId());
        List<Booking> pendingBooks = ownerBookings.stream()
                .filter(x -> x.getStatus().equals(BookingStatus.RESERVED))
                .collect(Collectors.toList());
        Map<Long, String> bookings = new HashMap<>();
        for (Booking booking : pendingBooks) {
            bookings.put(booking.getId(), booking.getName());
        }
        return bookings;
    }


    @RequestMapping(
            value = "/approveTransaction",
            method = RequestMethod.GET)
    public String approveTransaction(@RequestParam("id") Long id) {
        try {
            Booking booking = bookingRepository.getById(id);
            bookingRepository.updateBookingStatus(BookingStatus.BOOKED, booking.getId());
            return "Successful";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Failed";
        }
    }

    @RequestMapping(
            value = "/rejectTransaction",
            method = RequestMethod.GET)
    public String rejectTransaction(@RequestParam("id") Long id) {
        try {
            Booking booking = bookingRepository.getById(id);
            bookingRepository.deleteById(id);
            productRepository.updateIsAvailability(Boolean.TRUE, booking.getProductId());
            return "Successful";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Failed";
        }
    }
}
