package com.example.demo.service.jpa;

import com.example.demo.entity.VueMember;
import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.MemberAuth;
import com.example.demo.newcontroller.jpa.MemberRequest.MemberRequest;
import com.example.demo.repository.VueJPAMemberReopsitory;
import com.example.demo.repository.jpa.MemberAuthReopsitory;
import com.example.demo.repository.jpa.MemberReopsitory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MemberTestServiceimpl implements MemberTestService {
  @Autowired
  private MemberReopsitory memberRepository;

  @Autowired
  private MemberAuthReopsitory memberAuthRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void register(MemberRequest memberRequest) throws Exception {
    String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
    memberRequest.setPassword(encodedPassword);

    MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
    Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword());
    memberEntity.addAuth(authEntity);

    memberRepository.save(memberEntity);
  }

  @Override
  public boolean login(MemberRequest memberRequest) throws Exception {
    Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getUserId());

    if (maybeMember == null)
    {
      log.info("login(): 그런 사람 없다.");
      return false;
    }

    Member loginMember = maybeMember.get();

    if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword()))
    {
      log.info("login(): 비밀번호 잘못 입력하였습니다.");
      return false;
    }

    return true;
  }

    /*
    @Override
    public List<Member> list() throws Exception {
        return repository.list();
    }
     */

  @Override
  public Optional<Member> findByAuth(Long memberNo) {
    return memberRepository.findByAuth(memberNo);
  }

  @Override
  public boolean checkUserIdValidation(String userId) throws Exception {
    Optional<Member> maybeMember = memberRepository.findByUserId(userId);

    if (maybeMember == null)
    {
      log.info("login(): 그런 사람 없다.");
      return false;
    }

    return true;
  }
}