package com.example.demo.service.hybrid;

import com.example.demo.entity.hybrid.request.RequestHybridOrder;

public interface HybridOrderService {
    public  Boolean registerOrder (RequestHybridOrder order) throws  Exception;

    public  String notice (RequestHybridOrder order)  throws  Exception;

}
