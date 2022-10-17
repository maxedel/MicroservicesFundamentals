package com.epam.resourceProcessor.producer;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.function.Function;

@Component
public class SongMetadataSource {

	private static final Logger LOGGER = LoggerFactory.getLogger(SongMetadataSource.class);
	@Retryable(
			value = {SocketTimeoutException.class},
			maxAttempts = 2,
			backoff = @Backoff(delay = 1000)
	)
	@Bean
	public Function<String, Mp3File> convertToMp3() {
		return (value) -> {
			Mp3File mp3file = null;
			try {
				mp3file = new Mp3File(value);
			} catch (IOException | UnsupportedTagException | InvalidDataException e) {
				LOGGER.error("Can not parse mp3 file {}", value, e);
			}
			return mp3file;
		};
	}
}
