package com.example.demo.repository.hybrid;

import com.example.demo.entity.hybrid.HybridOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HybridOrderRepository extends JpaRepository<HybridOrder,Long> {
}
