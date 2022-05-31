package com.realLacuni.migraineweather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() { //Will tell spring boot to map to index.html for this path
        return "index"; 
    }

}
