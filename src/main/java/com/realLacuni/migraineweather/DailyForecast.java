package com.realLacuni.migraineweather;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;




@Entity
public class DailyForecast {

	
    private @Id String id;
    private String date;
    private int temperature;
    private int humidity;
    private int pressure;
	@NotBlank(message="City, State or Zip Code required.")
	private String location;

    private DailyForecast() {}

    public DailyForecast(String date, String location, int temperature, int humidity, int pressure) {
        this.date = date;
		//location will be either city, state or zip - converted by api
		this.location = location;
		this.id = location + ":" + date;
		//Webclient in here?
		//Then we have our front-end make a get request using just a date and it calls this which sends the date to our api
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }
    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DailyForecast DailyForecast = (DailyForecast) o;

		return Objects.equals(id, DailyForecast.id) &&
			Objects.equals(date, DailyForecast.date) &&
			Objects.equals(location, DailyForecast.location) &&
			Objects.equals(temperature, DailyForecast.temperature) &&
			Objects.equals(humidity, DailyForecast.humidity) &&
            Objects.equals(pressure, DailyForecast.pressure);

	}

	@Override
	public int hashCode() {

		return Objects.hash(id, date, location, temperature, pressure, humidity);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}	
	public String getLocation(String location) {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
}

	@Override
	public String toString() {
		return "DailyForecast{" +
			"id=" + id +
			", date='" + date + '\'' +
			", location ='" + location + '\'' +
			", temperature='" + temperature + '\'' +
			", pressure='" + pressure + '\'' +
			", humidity='" + humidity + '\'' +
			'}';
	}
}

