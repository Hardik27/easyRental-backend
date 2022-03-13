package com.example.easyrental.dao;

import com.example.easyrental.model.Booking;
import com.example.easyrental.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBookingByOwnerUserId(Long userId);

    @Modifying
    @Transactional
    @Query("update Booking u set u.status = ?1  where u.id = ?2")
    void updateBookingStatus(BookingStatus bookingStatus, Long id);
}
