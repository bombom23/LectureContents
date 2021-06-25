package com.example.market3.Service;

import com.example.market3.Entity.Login;
import com.example.market3.Entity.Market;
import com.example.market3.Entity.Signup;

import java.util.List;

public interface marketService {
    public void register(Market market);
    public List<Market> list() throws Exception;

    public  Market read(Integer productNo) throws  Exception;

    public void remove(Integer productNo) throws  Exception;

    public  void modify(Market market) throws  Exception;
    public void signup(Signup signup);

    public int logincheck(Login login);



}