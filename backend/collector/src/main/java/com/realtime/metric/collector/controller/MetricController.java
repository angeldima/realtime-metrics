package com.realtime.metric.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.realtime.metric.collector.model.MachineMetric;
import com.realtime.metric.collector.service.MachineService;
import com.realtime.metric.collector.service.MetricService;

@EnableScheduling
@Controller
public class MetricController {

	@Autowired
	private SimpMessagingTemplate template;
	@Autowired
	private MetricService metricService;
	@Autowired
	private MachineService machineService;

	@Scheduled(fixedRate = 3000)
	public void machineMetricsSimulator() throws InterruptedException {
		Thread.sleep(1000); // simulated delay
		String machine = machineService.getRandomMachine();
		MachineMetric machineMetric = metricService.randomMachineMetric();
		System.out.println("sent to /topic/" + machine);
		this.template.convertAndSend("/topic/" + machine, machineMetric);
	}

	@MessageMapping("/chosemachine")
	public void greeting(String message) throws Exception {
		Thread.sleep(1000); // simulated delay
		System.out.println(message);
	}

}
