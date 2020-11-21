package com.realtime.metric.collector.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.realtime.metric.collector.model.MachineMetric;
import com.realtime.metric.collector.model.TyreMetric;

@Service
public class MetricService {

	public MachineMetric randomMachineMetric() {
		Date currentDate = new Date();
		Random r = new Random();
		MachineMetric mm = new MachineMetric();
		mm.setTyreMetrics(new HashMap<String, TyreMetric>());
		mm.getTyreMetrics().put("Front Left", new TyreMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.getTyreMetrics().put("Rear Left", new TyreMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.getTyreMetrics().put("Rear Rigth", new TyreMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.getTyreMetrics().put("Front Rigth", new TyreMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		return mm;
	}
}
