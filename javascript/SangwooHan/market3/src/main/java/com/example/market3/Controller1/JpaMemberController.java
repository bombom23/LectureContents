package com.example.market3.Controller1;

import com.example.market3.Controller1.MemberRequset.MemberRequest;
import com.example.market3.Controller1.MemberRequset.ProductBasketRequest;
import com.example.market3.Controller1.Session.UserInfo;
import com.example.market3.Entity.JpaMember;
import com.example.market3.Entity.JpaMemberBasket;
import com.example.market3.Service.JpaMemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jpamemberManage")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class JpaMemberController {

    private HttpSession session;

    private UserInfo info;

    @Autowired
    JpaMemberService service;

    @PostMapping("/register")
    public  ResponseEntity<Void> jpaMemberRegister (
            @Validated @RequestBody MemberRequest memberRequest) throws  Exception {
            service.register(memberRequest);

            return new ResponseEntity<Void>(HttpStatus.OK);
    }



    @GetMapping("/lists")
    public ResponseEntity<List<JpaMember>> getListsMembers () throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }
    @GetMapping("/{memberNo}")
    public ResponseEntity<JpaMember> read(@PathVariable("memberNo") Long memberNo) throws Exception {
        Optional<JpaMember> jpaMember = service.read(memberNo);
        JpaMember jpaMember1 = jpaMember.get();
        log.info("jpa" + jpaMember1);
        return new ResponseEntity<JpaMember>(jpaMember1, HttpStatus.OK);
    }
    @PutMapping("/{memberNo}")
    public ResponseEntity<JpaMember> modifyMember(@PathVariable("memberNo") Long memberNo,
                                                 @Validated @RequestBody JpaMember jpaMember) throws Exception {

            jpaMember.setMemberNo(memberNo);


        service.modify(jpaMember);

       return new ResponseEntity<JpaMember>(jpaMember, HttpStatus.OK);

    }







    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody MemberRequest memberRequest, HttpServletRequest request) throws Exception {

        log.info("jpaLogin() - userId: " + memberRequest.getUserid() + ", password: " + memberRequest.getPassword());

        Boolean isSuccess = service.login(memberRequest);

        if (isSuccess) {
            log.info("Login Success");
            // 새션 할당 부분
            info = new UserInfo();
            info.setUserid(memberRequest.getUserid());
            log.info("Session Info:" + info );

            session = request.getSession();
            session.setAttribute("member", info);
        } else {
            log.info("Login Failure");
            info = null;
        }

       // return new ResponseEntity<UserInfo>(isSuccess, HttpStatus.OK);
        return  new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }

    @PostMapping("/needSession")
    public ResponseEntity<Boolean> postNeedSession(HttpServletRequest request) throws Exception {

        //UserInfo info = (UserInfo) session.getAttribute("member");
        Object obj = session.getAttribute("member");

        Boolean isLogin = false;

        if (obj != null) {
            log.info("Session Info: " + info);

            isLogin = service.checkUserIdValidation(info.getUserid());

            return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
        }

        return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
    }

    // 로그인 -> 게시물 작성
    //       -> 게시물 수정
    //       -> 팔로우
    //       -> 댓글 달기
    //       -> 삭제

    // 로그아웃 -> 게시물 작성
    // Spring 자체에서 처리가 불가능하므로
    // 로그아웃시 Vue쪽에 세션이 없다는 정보를 전달해줘야한다.
    // 그리고 사용자가 게시물 작성을 누르면 이 정보(참, 거짓)을 보고
    // 강제로 로그인 페이지로 보내거나 참(세션이 있음)이면 그대로 처리하는 방식을 취하도록 만들면 됨
    @PostMapping("/removeSession")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }
    @DeleteMapping("{memberNo}")
    public ResponseEntity<Void> remove(@PathVariable Long memberNo) throws Exception{

        service.remove(memberNo);

        return new ResponseEntity<Void>( HttpStatus.OK);
    }

    @PostMapping("/addBasket/{memberNo}")
    public  ResponseEntity<Void> addBasket(@PathVariable("memberNo")Long memberNo, @Validated @RequestBody ProductBasketRequest productBasketRequest) throws  Exception {
        System.out.println(memberNo);
        productBasketRequest.setMemberNo(memberNo);
        service.addBasket(productBasketRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/getBasketList/{memberNo}")
    public ResponseEntity<List<JpaMemberBasket>> getBasketList(@PathVariable("memberNo") Long memberNo) throws  Exception {


        service.getBasketList(memberNo);

        return new ResponseEntity<>(service.getBasketList(memberNo),HttpStatus.OK);
    }

    @PostMapping("/ModifyProductNum/{memberNo}")
    public ResponseEntity<Void> ModifyProductNum (@PathVariable("memberNo") Long memberNo, @Validated @RequestBody ProductBasketRequest productBasketRequest) throws  Exception {

        productBasketRequest.setMemberNo(memberNo);

        service.ModifyProductNum(productBasketRequest);

        return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/deleteProduct/{memberBasketNo}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("memberBasketNo")Long memberBasketNo) throws  Exception {

        service.deleteProduct(memberBasketNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
