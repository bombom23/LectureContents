package com.example.market3.Controller1;

import com.example.market3.Entity.JpaBoard;
import com.example.market3.Entity.JpaProduct;
import com.example.market3.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jpaProduct")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class JpaProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<Void> register (@Validated @RequestBody JpaProduct jpaProduct) throws  Exception{

        productService.register(jpaProduct);
        return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("getProductList")
    public ResponseEntity<List<JpaProduct>> getProductList() throws  Exception {
        productService.getProductList();

        return new ResponseEntity<>(productService.getProductList(),HttpStatus.OK);
    }
    @GetMapping("/getProduct/{boardNo}")
    public ResponseEntity<JpaProduct> getProduct (@PathVariable("boardNo") Long boardNo) throws  Exception {

        Optional<JpaProduct> jpaProduct = productService.getProduct(boardNo);
        JpaProduct jpaProduct1  = jpaProduct.get();
        return new ResponseEntity<>(jpaProduct1,HttpStatus.OK);
    }
}
