package com.realLacuni.migraineweather;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface DailyForecastRepository extends CrudRepository<DailyForecast, String> {
    Optional<DailyForecast> findById(String id);
}