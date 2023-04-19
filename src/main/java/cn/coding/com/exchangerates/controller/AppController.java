package cn.coding.com.exchangerates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {


    @GetMapping("/")
    private String homePage() {
        return "home";
    }

    @GetMapping("/contact")
    private String contact() {
        return "contact";
    }
}
