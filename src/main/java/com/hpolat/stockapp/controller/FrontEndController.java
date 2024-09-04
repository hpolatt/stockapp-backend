package com.hpolat.stockapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontEndController {
    @RequestMapping(value = "/{path:^(?!.*\\.).*$}")
    public String redirect() {
        return "forward:/";
    }
}

// cp -r src/main/frontend/stockapp-frontend/build/* src/main/resources/static/