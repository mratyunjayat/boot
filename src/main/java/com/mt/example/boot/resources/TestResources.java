package com.mt.example.boot.resources;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class TestResources {

	@RequestMapping("/")
	public String testing() {

//		Flux<String> namesFlux = Flux.fromIterable(List.of("Jay", "Suresh", "Raj")).subscribe();

		return "SUCCESS";
	}
}
