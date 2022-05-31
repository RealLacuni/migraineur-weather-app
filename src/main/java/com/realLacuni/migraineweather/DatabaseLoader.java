
package com.realLacuni.migraineweather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component 
public class DatabaseLoader implements CommandLineRunner {  

	private final DailyForecastRepository dayRepo;

	@Autowired
	public DatabaseLoader(DailyForecastRepository dayRepo) {
		this.dayRepo = dayRepo;
	}

	@Override
	public void run(String... strings) throws Exception { 
		this.dayRepo.save(new DailyForecast("20220703", "11222", 5, 5, 5));
	}
}