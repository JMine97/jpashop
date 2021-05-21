package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //url 이름
    public String hello(Model model){ //model에 데이터를 실어 view에 넘긴다
        model.addAttribute("data", "hello");
        return "hello"; //html 이름
    }
}
