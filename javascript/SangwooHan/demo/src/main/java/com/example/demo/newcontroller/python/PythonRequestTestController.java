package com.example.demo.newcontroller.python;


import com.example.demo.newcontroller.python.Entity.Product;
import com.example.demo.newcontroller.python.Entity.Stagbeetle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class PythonRequestTestController {
    // Controller 와 RestController 의 가장 큰 차이점

    // json 파일을 왓다갓다 하는게 많기에 레스트컨트롤러를사용한다.

    @GetMapping("/spring2pythonRequest")
    public ModelAndView doRequestPythonRest(Model model) {
        log.info("doRequestPythonRest()");

        List<HttpMessageConverter<?>> converters =
                new ArrayList<HttpMessageConverter<?>>();

        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setMessageConverters(converters);

        String result = restTemplate.getForObject(
                "http://localhost:5000/spring2pythonRequest",
                String.class
        );
        log.info("result:" + result);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("python/PyResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;

    }

    @GetMapping("/spring2pythonRequestMulti")
    public ModelAndView spring2pythonRequestMulti(Model model) {
        log.info("doRequestPythonRest()");

        List<HttpMessageConverter<?>> converters =
                new ArrayList<HttpMessageConverter<?>>();

        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setMessageConverters(converters);

        String result = restTemplate.getForObject(
                "http://localhost:5000/spring2pythonRequestMulti",
                String.class
        );
        log.info("result:" + result);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("python/PyResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;

    }

    @GetMapping("/spring2pythonRequestWithData")
    public ModelAndView spring2pythonRequestWithData(Model model) {
        log.info("spring2pythonRequestWithData()");

        RestTemplate restTemplate = new RestTemplate();

        Product product = new Product(350000);
       // 여기서 보낼때는 반드시 Entity의형태의 객체를 보낸다.
        String result = restTemplate.postForObject(
                "http://localhost:5000/spring2pythonRequestWithData",
                product,
                String.class
        );

        log.info("result:" + result);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("python/PyResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;

    }

    @GetMapping("/Stagbeetle")
    public ModelAndView Stagbeetle(Model model) {
        log.info("Stagbeetle()");

        RestTemplate restTemplate = new RestTemplate();

        Stagbeetle stagbeetle  = new Stagbeetle("Stagbeetle");


        // 여기서 보낼때는 반드시 Entity의형태의 객체를 보낸다.
        String result = restTemplate.postForObject(
                "http://localhost:5000/Stagbeetle",
                stagbeetle,
                String.class
        );

        log.info("result:" + result);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("python/PyResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;

    }
}
