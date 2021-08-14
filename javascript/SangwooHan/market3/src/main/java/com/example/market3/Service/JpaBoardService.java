package com.example.market3.Service;

import com.example.market3.Entity.JpaBoard;
import com.example.market3.Entity.JpaMember;

import java.util.List;

public interface JpaBoardService {
    public void register(JpaBoard jpaBoard) throws  Exception;

    public List<JpaBoard> boardlist() throws Exception;
}
