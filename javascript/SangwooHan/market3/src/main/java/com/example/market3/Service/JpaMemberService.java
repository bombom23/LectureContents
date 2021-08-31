package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.MemberRequest;
import com.example.market3.Controller1.MemberRequset.ProductBasketRequest;
import com.example.market3.Entity.JpaMember;
import com.example.market3.Entity.JpaMemberBasket;

import java.util.List;
import java.util.Optional;

public interface JpaMemberService {
    public  void register(MemberRequest memberRequest) throws  Exception;

    public List<JpaMember> list() throws Exception;

    public Optional<JpaMember> read (Long memberNo) throws Exception;

    public boolean login(MemberRequest memberRequest) throws Exception;

    public boolean checkUserIdValidation(String userid) throws Exception;

    public void modify(JpaMember jpaMember) throws  Exception;

    public void remove (Long memberNo) throws  Exception;

    public  void addBasket(ProductBasketRequest productBasketRequest) throws  Exception;

    public  List<JpaMemberBasket> getBasketList(Long memberNo) throws  Exception;

    public  void ModifyProductNum(ProductBasketRequest productBasketRequest);

    public  void deleteProduct(Long memberBasketNo) throws  Exception;


}