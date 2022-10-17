package com.epam.resourceService.publisher;

import com.epam.resourceService.entity.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.net.SocketTimeoutException;


@Service
public class RabbitMQProducer {

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

	private RabbitTemplate rabbitTemplate;

	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	@Retryable(
			value = {SocketTimeoutException.class},
			maxAttempts = 2,
			backoff = @Backoff(delay = 1000)
	)
	public void sendMessage(Resource resource){
		LOGGER.info(String.format("Message sent -> %s", resource));
		rabbitTemplate.convertAndSend(exchange, routingKey, resource);
	}
}
