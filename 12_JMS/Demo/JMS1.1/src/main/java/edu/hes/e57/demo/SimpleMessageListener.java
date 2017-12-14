package edu.hes.e57.demo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleMessageListener implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMessageListener.class);

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            LOGGER.info("Message received: " + textMessage.getText());
        } catch (JMSException ex) {
            LOGGER.error("JMS error", ex);
        }
    }
}
