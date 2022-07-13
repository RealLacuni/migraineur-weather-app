package com.realLacuni.migraineweather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ResultController {

    @GetMapping(value="/day/{id}")
    public void dayOfDate(@PathVariable("id") String id) {
        //Use OUR api to try to find it on our database if it's not there, we use the other api, and add it to our database
        ; //returns an Optional<Day>, onlyt time it doesn't is if the other api so also down
    }

    @GetMapping(value="/day/{start}:{end}:")
    public void weekOfDates(@PathVariable("start") String start, @PathVariable("end") String end) {

    }

    public String result() {
        return "result";
    
    }

    
}
