package com.example.entities;

import com.example.projections.ProCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p JOIN FETCH p.categories")
    List<Product> allPro();

    @Query(value = "select PRODUCT.PID, PRODUCT.TITLE, C.NAME from PUBLIC.PRODUCT inner join PUBLIC.PRODUCT_CATEGORIES PC on PRODUCT.PID = PC.PRODUCT_PID inner join PUBLIC.CATEGORY C on C.CID = PC.CATEGORIES_CID", nativeQuery = true)
    List<ProCat> proCats();
}