package com.example.market3.Service;

import com.example.market3.Entity.JpaProduct;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    public  void register (JpaProduct jpaProduct)throws  Exception;

    public List<JpaProduct> getProductList() throws  Exception;

    public Optional<JpaProduct> getProduct(Long boardNo) throws Exception;
}
