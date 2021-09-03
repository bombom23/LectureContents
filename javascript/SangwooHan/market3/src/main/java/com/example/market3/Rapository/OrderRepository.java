package com.example.market3.Rapository;

import com.example.market3.Entity.JpaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface OrderRepository extends JpaRepository<JpaOrder,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE JpaOrder j set j.state = :Shipping  where j.orderNo = :orderNo")
    void Shipping1(@Param("orderNo") Long orderNo,@Param("Shipping")String Shipping);

    @Transactional
    @Modifying
    @Query("UPDATE JpaOrder j set j.productNum = j.productNum -j.productNum + :Quantity where j.orderNo =:orderNo")
    void QuantityChange(@Param("orderNo")Long orderNo, @Param("Quantity") Integer Quantity);

}
