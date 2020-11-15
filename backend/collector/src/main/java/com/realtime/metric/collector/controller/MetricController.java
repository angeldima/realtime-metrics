package com.realtime.metric.collector.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.realtime.metric.collector.model.WheelMetric;

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
		Date currentDate = new Date();		
		Map<String, WheelMetric> mm = new HashMap<String, WheelMetric>();
		mm.put("Front Left", new WheelMetric(currentDate, 2.54999995232F, 9.0F, 45.4199999641F, 51.0111111535F));
		mm.put("Rear Left", new WheelMetric(currentDate, 2.54999995232F, 9.0F, 45.4199999641F, 51.0111111535F));
		mm.put("Rear Rigth", new WheelMetric(currentDate, 2.54999995232F, 9.0F, 45.4199999641F, 51.0111111535F));
		mm.put("Front Rigth", new WheelMetric(currentDate, 2.54999995232F, 9.0F, 45.4199999641F, 51.0111111535F));
		
		System.out.println("scheduled");
		this.template.convertAndSend("/topic/demo", mm);
	}

}
