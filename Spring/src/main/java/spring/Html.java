package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Html {
    @GetMapping("/")
    public String ind(){
        return "index.html";
    }
}
