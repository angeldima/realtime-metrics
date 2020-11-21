package com.realtime.metric.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

import com.realtime.metric.collector.service.MachineMetricEvent;

@EnableScheduling
@Controller
public class MetricController implements ApplicationListener<MachineMetricEvent> {

	@Autowired
	private SimpMessagingTemplate template;

	@Override
	public void onApplicationEvent(MachineMetricEvent event) {
		System.out.println("Received event for machine: " + event.getMachineId());
		System.out.println("Sent message to /topic/" + event.getMachineId());
		this.template.convertAndSend("/topic/" + event.getMachineId(), event.getMachineMetric());
	}

	@MessageMapping("/chosemachine")
	public void greeting(String message) throws Exception {
		Thread.sleep(2000); // simulated delay
		System.out.println(message);
	}

}
