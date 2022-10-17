package com.epam.resourceProcessor.consumer;

import com.epam.resourceProcessor.entity.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.net.SocketTimeoutException;

@Service
public class RabbitMQConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
	@Retryable(
			value = {SocketTimeoutException.class},
			maxAttempts = 2,
			backoff = @Backoff(delay = 1000)
	)
	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
	public void consume(Resource resource){
		LOGGER.info(String.format("Received message -> %s", resource));
	}
}
