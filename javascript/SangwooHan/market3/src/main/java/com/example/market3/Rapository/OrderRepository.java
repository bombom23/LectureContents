package com.example.market3.Rapository;

import com.example.market3.Entity.JpaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<JpaOrder,Long> {
}
