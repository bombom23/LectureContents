package com.example.demo.newcontroller.hybrid;


import com.example.demo.entity.hybrid.request.RequestHybridOrder;
import com.example.demo.service.hybrid.HybridOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/ordertest")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class HybridOrderTestController {

    @Autowired
    HybridOrderService service ;


    @PostMapping("/order")
    public Boolean hybridOrder(@RequestBody RequestHybridOrder order) throws Exception {
        log.info("hybridOrder(): " + order);

        Boolean registerSuccess = service.registerOrder(order);
        String check = service.notice(order);
        log.info("check : " + check);

        if (!registerSuccess) {
            return false;
        }

        return true;
    }
}
