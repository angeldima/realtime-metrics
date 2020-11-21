package com.realtime.metric.collector.service;

import org.springframework.context.ApplicationEvent;

import com.realtime.metric.collector.model.MachineMetric;

public class MachineMetricEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private MachineMetric machineMetric;
	private String machineId;

	public MachineMetricEvent(Object source, String machineId, MachineMetric machineMetric) {
		super(source);
		this.machineMetric = machineMetric;
		this.machineId = machineId;
	}

	public MachineMetric getMachineMetric() {
		return machineMetric;
	}

	public String getMachineId() {
		return this.machineId;
	}
}
