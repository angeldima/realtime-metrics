package com.realtime.metric.collector.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

//	@Scheduled(fixedRate = 5000)
//	public void machine1Metrics() throws InterruptedException {
//		Thread.sleep(1000); // simulated delay
//		Date currentDate = new Date();
//		Map<String, WheelMetric> mm = new HashMap<String, WheelMetric>();
//		mm.put("Front Left", new WheelMetric(currentDate, 2.54999995232F, 9.0F, 45.4199999641F, 51.0111111535F));
//		mm.put("Rear Left", new WheelMetric(currentDate, 2.54999995232F, 9.0F, 45.4199999641F, 51.0111111535F));
//		mm.put("Rear Rigth", new WheelMetric(currentDate, 2.54999995232F, 9.0F, 45.4199999641F, 51.0111111535F));
//		mm.put("Front Rigth", new WheelMetric(currentDate, 2.54999995232F, 9.0F, 45.4199999641F, 51.0111111535F));
//
//		System.out.println("sent to /topic/demo");
//		this.template.convertAndSend("/topic/demo", mm);
//	}

	@Scheduled(fixedRate = 60000)
	public void machine2Metrics() throws InterruptedException {
		Thread.sleep(1000); // simulated delay
		Date currentDate = new Date();
		Random r = new Random();
		Map<String, WheelMetric> mm = new HashMap<String, WheelMetric>();
		mm.put("Front Left", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.put("Rear Left", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.put("Rear Rigth", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.put("Front Rigth", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));

		System.out.println("sent to /topic/Volvo V40");
		this.template.convertAndSend("/topic/Volvo V40", mm);
	}
	
	@Scheduled(fixedRate = 30000)
	public void machine3Metrics() throws InterruptedException {
		Thread.sleep(1000); // simulated delay
		Date currentDate = new Date();
		Random r = new Random();
		Map<String, WheelMetric> mm = new HashMap<String, WheelMetric>();
		mm.put("Front Left", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.put("Rear Left", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.put("Rear Rigth", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.put("Front Rigth", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));

		System.out.println("sent to /topic/Porsche 911");
		this.template.convertAndSend("/topic/Porsche 911", mm);
	}
	
	@Scheduled(fixedRate = 30000)
	public void machine4Metrics() throws InterruptedException {
		Thread.sleep(1000); // simulated delay
		Date currentDate = new Date();
		Random r = new Random();
		Map<String, WheelMetric> mm = new HashMap<String, WheelMetric>();
		mm.put("Front Left", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.put("Rear Left", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.put("Rear Rigth", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));
		mm.put("Front Rigth", new WheelMetric(currentDate, 2F + r.nextFloat() * (5F - 2F),
				9F + r.nextFloat() * (15F - 9F), 40F + r.nextFloat() * (45F - 40F), 50F + r.nextFloat() * (60F - 50F)));

		System.out.println("sent to /topic/Audi A6");
		this.template.convertAndSend("/topic/Audi A6", mm);
	}

}
