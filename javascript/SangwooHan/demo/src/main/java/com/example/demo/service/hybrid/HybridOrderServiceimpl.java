package com.example.demo.service.hybrid;

import com.example.demo.entity.hybrid.HybridOrder;
import com.example.demo.entity.hybrid.request.RequestHybridOrder;
import com.example.demo.repository.hybrid.HybridOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import utlity.python.PythonRequestUtil;

@Service
public class HybridOrderServiceimpl  implements  HybridOrderService{

    @Autowired
    HybridOrderRepository repository ;

    @Override
    public Boolean registerOrder(RequestHybridOrder order) throws Exception {

        HybridOrder hybridOrder = new HybridOrder(order.getName(), order.getCost());
        repository.save(hybridOrder);
        return true;
    }

    @Override
    public String notice(RequestHybridOrder order) throws Exception {
        // Python으로 REST 요청을 수행해야함
        PythonRequestUtil pru = new PythonRequestUtil();

        // REST 쏘고 성공 여부를 받아오도록한다.

        return  pru.orderTest(order);

    }
}
