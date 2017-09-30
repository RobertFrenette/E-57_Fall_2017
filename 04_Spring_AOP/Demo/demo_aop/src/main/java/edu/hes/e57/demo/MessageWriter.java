package edu.hes.e57.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageWriter {
	private static Logger logger = LoggerFactory.getLogger(MessageWriter.class);

	public void writeMessage() {
		logger.info("World");
	}
}
