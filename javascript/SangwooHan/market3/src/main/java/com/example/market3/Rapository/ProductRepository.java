package com.example.market3.Rapository;

import com.example.market3.Entity.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<JpaProduct,Long> {
}
