package com.epam.resourceService.controller;

import com.epam.resourceService.entity.Resource;
import com.epam.resourceService.publisher.RabbitMQProducer;
import com.epam.resourceService.service.ResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {

	private ResourceService resourceService;

	private RabbitMQProducer producer;

	public ResourceController(ResourceService resourceService,
							  RabbitMQProducer producer) {
		this.resourceService = resourceService;
		this.producer = producer;
	}

	@GetMapping
	public ResponseEntity<List<Resource>> getAllResources() {
		try {
			List<Resource> resources = resourceService.findAll();

			if (resources.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(resources, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/{id}")
	public ResponseEntity<Resource> getResourceById(@PathVariable("id") long id) {
		return resourceService.getResourceById(id)
				.map(resource -> new ResponseEntity<>(resource, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> createResource(@RequestBody Resource resource) {
		try {
			long id = resourceService.createResource(resource);
			producer.sendMessage(resource);
			return new ResponseEntity<>(id, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteResource(@PathVariable(value = "id") Long id) {
		try {
			resourceService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
