package com.example.demo.service;

import com.example.demo.entity.VueMember;
import com.example.demo.repository.VueJPAMemberReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vueMemberTestServiceimpl  implements  vueMemberTestService{
  @Autowired
  private VueJPAMemberReopsitory reopsitory;
    @Override
    public void register(VueMember vueMember) throws Exception {
        reopsitory.save(vueMember);
    }
}
