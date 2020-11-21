package com.realtime.metric.collector.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.realtime.metric.collector.model.MachineMetric;
import com.realtime.metric.collector.model.TyreMetric;

@Service
@Component
public class MetricService {

	private static final String COMMA_DELIMITER = ",";

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public void publishMachineMetricEvent(final String machineId, final MachineMetric machineMetric) {
		MachineMetricEvent event = new MachineMetricEvent(this, machineId, machineMetric);
		applicationEventPublisher.publishEvent(event);
	}

	private void manageMachineMetric(List<List<String>> groupMetrics) {
		Date currentDate = new Date();
		MachineMetric mm = new MachineMetric();
		String machineId = groupMetrics.get(0).get(7);
		mm.setTyreMetrics(new HashMap<String, TyreMetric>());
		manageTyreMetric(mm, currentDate, groupMetrics.get(0));
		manageTyreMetric(mm, currentDate, groupMetrics.get(1));
		manageTyreMetric(mm, currentDate, groupMetrics.get(2));
		manageTyreMetric(mm, currentDate, groupMetrics.get(3));
		publishMachineMetricEvent(machineId, mm);
	}

	private void manageTyreMetric(MachineMetric mm, Date currentDate, List<String> tyreMetricList) {
		String position = tyreMetricList.get(3);
		Float pressure = Float.parseFloat(tyreMetricList.get(2));
		Float temperature = Float.parseFloat(tyreMetricList.get(4));
		Float angularVelocity = Float.parseFloat(tyreMetricList.get(5));
		Float speed = Float.parseFloat(tyreMetricList.get(6));
		TyreMetric tyreMetric = new TyreMetric(currentDate, pressure, temperature, angularVelocity, speed);
		mm.getTyreMetrics().put(position, tyreMetric);
	}

	@Scheduled(initialDelay = 4000, fixedDelay = 999999999)
	private void simulateVolvo() {
		simulateMetrics("volvo_dataset.csv");
	}
	
	@Scheduled(initialDelay = 5000, fixedDelay = 999999999)
	private void simulateAudi() {
		simulateMetrics("audi_dataset.csv");
	}
	
	@Scheduled(initialDelay = 3000, fixedDelay = 999999999)
	private void simulatePorsche() {
		simulateMetrics("porsche_dataset.csv");
	}
	
	@Scheduled(initialDelay = 2000, fixedDelay = 999999999)
	private void simulateRenault() {
		simulateMetrics("renault_dataset.csv");
	}

	private void simulateMetrics(String csvName) {
		List<List<String>> groupMetrics = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + csvName))) {
			String line;
			Integer groupCounter = 0;

			while ((line = br.readLine()) != null) {
				groupCounter++;
				String[] values = line.split(COMMA_DELIMITER);
				groupMetrics.add(Arrays.asList(values));
				if (groupCounter == 4) {
					manageMachineMetric(groupMetrics);
					groupCounter = 0;
					groupMetrics = new ArrayList<>();
					Thread.sleep(6000);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
