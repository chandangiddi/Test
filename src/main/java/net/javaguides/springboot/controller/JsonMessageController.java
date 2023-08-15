package net.javaguides.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.kafka.JsonkafkaProducer;
import net.javaguides.springboot.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	
	private JsonkafkaProducer kafkaProducer;

	public JsonMessageController(JsonkafkaProducer kafkaProducer) {
		 
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user){
		
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message sent to kafka topic");
	}
}
