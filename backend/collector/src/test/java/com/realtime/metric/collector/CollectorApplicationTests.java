package com.realtime.metric.collector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.realtime.metric.collector.model.MachineMetric;
import com.realtime.metric.collector.model.TyreMetric;
import com.realtime.metric.collector.service.MetricService;

@SpringBootTest
class CollectorApplicationTests {
	
	@Autowired
	private MetricService metricService;

	@Test
	void contextLoads() {
		Date currentDate = new Date();
		MachineMetric mm = new MachineMetric();
		mm.setTyreMetrics(new HashMap<String, TyreMetric>());
		List<String> tyreMetrics = Arrays.asList("1", "2017-03-03 00:00:00", "-2.75", "Rear Left", "29.0", "-70.9617082549", "79.8697624207", "Volvo V40");
		metricService.manageTyreMetric(mm, currentDate, tyreMetrics);
		Float actualPress = mm.getTyreMetrics().get("Rear Left").getPress();
		Float actualOmega = mm.getTyreMetrics().get("Rear Left").getOmega();
		assertEquals(0F, actualPress);
		assertEquals(0F, actualOmega);
	}

}
