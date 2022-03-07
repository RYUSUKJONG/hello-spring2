package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){  //model
        model.addAttribute("data", "hello!");
        //model의 key : data , value : "hello!"
        return "hello";    // templates/'return "값"'.html
    }

    @GetMapping("/hello-mvc")     // RequestParam ?name=Spring!!
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody       //html body부에 직접 넣음
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody          // --> HttpMessageConverter 동작 -> 단순 문자면 SpringConverter 객체면 JsonConverter
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;    //  객체는 json으로 반환 {"name" : "value"}
    }

    static class Hello{   //getter setter
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



}
