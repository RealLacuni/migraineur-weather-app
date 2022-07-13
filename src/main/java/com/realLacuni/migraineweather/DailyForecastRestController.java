package com.realLacuni.migraineweather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/forecast", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class DailyForecastRestController {
	private DailyForecastRepository forecastRepo;

    // WIP
    @Autowired
    public void DayController(DailyForecastRepository forecastRepo) {
        this.forecastRepo = forecastRepo;
    }

    @GetMapping
    public Iterable<DailyForecast> allForecasts() {
        return forecastRepo.findAll();
    }


    @GetMapping(value = "/{zip}:{location}:")
    public DailyForecast getDayForecast(@PathVariable("date") String date, @PathVariable("location") String location) {
            List<DailyForecast> filteredList = forecastRepo.findByDateAndlocation(date, location);
            if (filteredList.size() == 0) {
                //call external api and save results
            }

            //return json object of the day
            return filteredList.get(0);
    }

}
