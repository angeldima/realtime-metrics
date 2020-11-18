package com.realtime.metric.collector.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MachineController {

	@GetMapping("/machines")
    public List<String> getMachines() {
		List<String> availableMachine = new ArrayList<String>();
		availableMachine.add("Volvo V40");
		availableMachine.add("Audi A6");
		availableMachine.add("Porsche 911");
        return availableMachine;
    }
}
