package com.example.teamprojectSpring.Service;

import com.example.teamprojectSpring.Entity.FreeBoard;
import com.example.teamprojectSpring.Repository.TestRepository;
import com.example.teamprojectSpring.Request.TestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceimpl implements TestService{

    @Autowired
    TestRepository testRepository ;

    @Override
    public void register(TestRequest testRequest) throws Exception {

        FreeBoard freeBoard  = new FreeBoard(testRequest.getUserid(), testRequest.getTitle(), testRequest.getText(), testRequest.getImg());
        testRepository.save(freeBoard);
    }
}
