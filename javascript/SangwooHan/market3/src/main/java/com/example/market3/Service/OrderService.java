package com.example.market3.Service;

import com.example.market3.Entity.JpaOrder;

import java.util.List;

public interface OrderService {

    public void register(JpaOrder jpaOrder)throws  Exception;

    public List<JpaOrder> getOrderList() throws  Exception;

}
