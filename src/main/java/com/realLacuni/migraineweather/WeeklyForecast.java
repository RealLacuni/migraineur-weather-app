package com.realLacuni.migraineweather;

import java.util.ArrayList;
import java.util.List;

public class WeeklyForecast {
    private List<DailyForecast> daysOfWeek = new ArrayList<>();

    public void addDailyForecast(DailyForecast day) {
        this.daysOfWeek.add(day);
    }
    
}
