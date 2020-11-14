package com.realtime.metric.collector.model;

public class MetricPayload {

	private String timestamp;
	private Float press;
	private String position;
	private Float temp;
	private Float omega;
	private Float speed;
	private String car_id;

	public MetricPayload(String timestamp, Float press, String position, Float temp, Float omega, Float speed,
			String car_id) {
		this.timestamp = timestamp;
		this.press = press;
		this.position = position;
		this.temp = temp;
		this.omega = omega;
		this.speed = speed;
		this.car_id = car_id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Float getPress() {
		return press;
	}

	public void setPress(Float press) {
		this.press = press;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public Float getOmega() {
		return omega;
	}

	public void setOmega(Float omega) {
		this.omega = omega;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

}
