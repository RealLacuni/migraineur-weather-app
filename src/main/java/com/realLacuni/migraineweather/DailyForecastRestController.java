package com.realLacuni.migraineweather;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

////////////////// WIP //////////////////////
// @RestController
// @RequestMapping(path="/api", produces="application/json")
// public class DailyForecastRestController {
//     private DailyForecastRepository dayRepo;

//     public DailyForecastRestController(DailyForecastRepository dayRepo) {
//         this.dayRepo = dayRepo;
//     }

//     @GetMapping("/")
//     public List<DailyForecast> getAllDailyForecasts() {
//         return (List<DailyForecast>) dayRepo.findAll();
//     }

// }
