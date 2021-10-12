package com.example.teamprojectSpring.Controller;

import com.example.teamprojectSpring.Request.TestRequest;
import com.example.teamprojectSpring.Service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class Test {
        @Autowired
        TestService service;

    @PostMapping("/register")
   public ResponseEntity<String> test( @Validated @RequestBody TestRequest testRequest) throws Exception {
         String Success  = "등록되었습니다.";
      service.register(testRequest);
        return new ResponseEntity<String>(Success, HttpStatus.OK);
    }

    @PostMapping("/uploadImg/{name}")
    @ResponseBody
    public String requestUploadFile(@RequestParam("fileList") List<MultipartFile> fileList ,@PathVariable("name") String name) {
        System.out.println("name = " +name );
        log.info("requestUploadFile(): " + fileList);

        try {
            // 결국 저장되는 위치가 images/사진파일명.확장자
            // images/아이디/사진파일명.확장자

            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile(): Make File");
                FileOutputStream writer = new FileOutputStream("C:\\Users\\tkddn\\java_work\\LectureContents\\javascript\\SangwooHan\\teamproject\\src\\assets/"
                        + name+"의"+multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();


            }


        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "success!";
    }
}
