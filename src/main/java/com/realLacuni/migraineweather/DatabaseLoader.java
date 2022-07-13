
package com.realLacuni.migraineweather;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//only temporary to work sample database

@Component 
public class DatabaseLoader implements CommandLineRunner {  

	private final DailyForecastRepository forecastRepo;

	public DatabaseLoader(DailyForecastRepository forecastRepo) {
		this.forecastRepo = forecastRepo;
	}

	@Override
	public void run(String... strings) throws Exception { 
		this.forecastRepo.save(new DailyForecast("20220703", "11222", 80, 5, 69));
		this.forecastRepo.save(new DailyForecast("20222505", "12206", 75, 5, 11));
		this.forecastRepo.save(new DailyForecast("20221224", "11206", 5, 5, 25));
		this.forecastRepo.save(new DailyForecast("20220703", "90210", 666, 5, 16));
	}
}