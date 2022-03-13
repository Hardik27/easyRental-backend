package com.example.easyrental.dao;

import com.example.easyrental.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Transactional
    @Query("update Product p set p.availability = ?1  where p.id = ?2")
    void updateIsAvailability(Boolean isAvailability, Long id);
}
