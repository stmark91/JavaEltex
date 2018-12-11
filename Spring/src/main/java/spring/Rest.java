package spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {
    @RequestMapping("/Hello")
    public String hello(){
        return "Hello";
    }
}