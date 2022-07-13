package com.realLacuni.migraineweather;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DailyForecastRepository extends CrudRepository<DailyForecast, String> {
    
    List<DailyForecast> findByDateAndlocation(String date, String location);
}