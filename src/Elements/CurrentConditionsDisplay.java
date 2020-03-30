package Elements;

import interfaces.DisplayElement;
import interfaces.Observer;
import interfaces.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temp;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Current conditions : "+ temp + "F degrees and " + humidity + "%humidity" );
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temp = temp;
		this.humidity = humidity;
		display();
	}

}
