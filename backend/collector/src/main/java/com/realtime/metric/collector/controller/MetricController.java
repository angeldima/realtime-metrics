package com.realtime.metric.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@EnableScheduling
@Controller
public class MetricController {

	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/chosemachine")
	public void greeting(String message) throws Exception {
		Thread.sleep(1000); // simulated delay
		System.out.println(message);
	}

	@Scheduled(fixedRate = 5000)
	public void machine1Metrics() throws InterruptedException {
		Thread.sleep(1000); // simulated delay
		System.out.println("scheduled");
		this.template.convertAndSend("/topic/demo", "test message");
	}

}
