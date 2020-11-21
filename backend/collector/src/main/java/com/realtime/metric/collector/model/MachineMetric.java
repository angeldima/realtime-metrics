package com.realtime.metric.collector.model;

import java.util.Map;

public class MachineMetric {

	Map<String, TyreMetric> tyreMetrics;

	public Map<String, TyreMetric> getTyreMetrics() {
		return tyreMetrics;
	}

	public void setTyreMetrics(Map<String, TyreMetric> tyreMetrics) {
		this.tyreMetrics = tyreMetrics;
	}

}
