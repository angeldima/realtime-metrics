package com.realtime.metric.collector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realtime.metric.collector.service.MachineService;

@RestController
@CrossOrigin(origins = "*")
public class MachineController {
	
	@Autowired
	private MachineService machineService;

	@GetMapping("/machines")
    public List<String> getMachines() {
		return machineService.getAvailableMachines();
    }
}
