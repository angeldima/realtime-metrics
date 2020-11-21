package com.realtime.metric.collector.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class MachineService {

	private List<String> machinesList = Arrays.asList("Volvo V40", "Audi A6", "Porsche 911");

	public List<String> getAvailableMachines() {		
		return machinesList;
	}
	
	public String getRandomMachine() {
		return randomMachine(machinesList);
	}
	
	private String randomMachine(List<String> machines) {
	    Random rand = new Random(); 
	    String randomMachine = machines.get(rand.nextInt(machines.size()));
	    return randomMachine;
	}
}
