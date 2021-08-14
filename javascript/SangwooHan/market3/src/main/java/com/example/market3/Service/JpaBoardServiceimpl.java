package com.example.market3.Service;

import com.example.market3.Entity.JpaBoard;
import com.example.market3.Rapository.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaBoardServiceimpl implements JpaBoardService{

    @Autowired
    JpaBoardRepository repository;

    @Override
    public void register(JpaBoard jpaBoard) throws Exception {
        repository.save(jpaBoard);
    }

    @Override
    public List<JpaBoard> boardlist() throws Exception {
        return repository.findAll();
    }
}
