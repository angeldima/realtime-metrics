package com.realtime.metric.collector.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MachineService {

	private List<String> machinesList = Arrays.asList("Renault 4", "Volvo V40", "Audi A6", "Porsche 911");

	public List<String> getAvailableMachines() {		
		return machinesList;
	}
	
}
