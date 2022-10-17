package com.epam.resourceProcessor.consumer;

import com.epam.resourceProcessor.entity.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
	public void consume(Resource resource){
		LOGGER.info(String.format("Received message -> %s", resource));
	}
}
