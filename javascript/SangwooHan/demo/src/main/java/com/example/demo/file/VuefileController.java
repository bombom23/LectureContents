package com.example.demo.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/file")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VuefileController {

    @PostMapping("/uploadImg")
    @ResponseBody
    public  String requestUploadFile(@RequestParam("fileList")List<MultipartFile> fileList) {

        log.info("requestFileList():" + fileList);

        try {
            for ( MultipartFile multipartFile : fileList ) {
                FileOutputStream writer = new FileOutputStream("./images" + multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        }catch (Exception e) {
            return "Upload Fail!";
        }
        return "UPload Success!";
    }
}
