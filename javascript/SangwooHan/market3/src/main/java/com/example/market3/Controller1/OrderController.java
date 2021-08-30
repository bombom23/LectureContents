package com.example.market3.Controller1;

import com.example.market3.Entity.JpaOrder;
import com.example.market3.Service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jpaOrder")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Validated @RequestBody JpaOrder jpaOrder) throws  Exception{

        orderService.register(jpaOrder);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/getOrderList")
    public ResponseEntity<List<JpaOrder>> getOrderList() throws  Exception {

        orderService.getOrderList();

        return new ResponseEntity<>(orderService.getOrderList(),HttpStatus.OK);
    }
}
