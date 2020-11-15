package com.realtime.metric.collector.model;

import java.util.Date;

public class WheelMetric {

	private Date timestamp;
	private Float press;
	private Float temp;
	private Float omega;
	private Float speed;

	public WheelMetric(Date timestamp, Float press, Float temp, Float omega, Float speed) {
		super();
		this.timestamp = timestamp;
		this.press = press;
		this.temp = temp;
		this.omega = omega;
		this.speed = speed;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Float getPress() {
		return press;
	}

	public void setPress(Float press) {
		this.press = press;
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

}
