package Subject;

import java.util.ArrayList;

import interfaces.Observer;
import interfaces.Subject;

public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData(){
		observers = new ArrayList<Observer>();
	}
	// Implement the Subject interfaces
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if(i > 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (int i= 0 ; i< observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	// Notify the observer if something changes
	public void measurementsChanged() {
		notifyObserver();
	}
	

	// This where the updates being propagated and changed
	public void setMeasurements(float temperature,float humidity,float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	
	
	

}
