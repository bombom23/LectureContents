package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.MemberRequest;
import com.example.market3.Entity.JpaMember;
import com.example.market3.Entity.JpaMemberAuth;
import com.example.market3.Rapository.JPAMemberRepository;
import com.example.market3.Rapository.MemberAuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JpaMemberServiceimpl implements JpaMemberService {

    @Autowired
    private JPAMemberRepository memberRepository;

    @Autowired
    MemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) throws Exception {

        //비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);


        // 엔티티에다가 리퀘스트멤버안에있는 Vue에서 받은 값들을 넣어주고있는 과정들이고
        // 조인컬럼에도 auth값을 넣어주고있다 .
        JpaMemberAuth jpaauthEntity = new JpaMemberAuth(memberRequest.getAuth());
        JpaMember jpaMemberEntity = new JpaMember(memberRequest.getUserid(), memberRequest.getPassword(), memberRequest.getName(), memberRequest.getEmail(), memberRequest.getBirthday(), memberRequest.getGender(),
                memberRequest.getAddress(), memberRequest.getPhoneNo());
        jpaMemberEntity.addAuth(jpaauthEntity);

        memberRepository.save(jpaMemberEntity);
    }

    @Override
    public List<JpaMember> list() throws Exception {
        return memberRepository.findAll();
    }

    @Override
    public Optional<JpaMember> read(Long memberNo) throws Exception {
        return memberRepository.findById(memberNo);
    }

    @Override
    public void modify(JpaMember jpaMember) throws Exception {
        String encodedPassword = passwordEncoder.encode(jpaMember.getPassword());
        jpaMember.setPassword(encodedPassword);
        memberRepository.save(jpaMember);
    }

    @Override
    public boolean login(MemberRequest memberRequest) throws Exception {


        Optional<JpaMember> maybeMember = memberRepository.findByUserId(memberRequest.getUserid());
        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        JpaMember loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword()))
        {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkUserIdValidation(String userid) throws Exception {
        Optional<JpaMember> maybeJpaMember = memberRepository.findByUserId(userid);

        if(maybeJpaMember == null){
             log.info("login():  there is no id");

             return  false;
        }


        return true;
    }


}
