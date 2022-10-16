package ma.poc.services.kafka.listener;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import ma.poc.services.kafka.messages.Message;
import ma.poc.services.kafka.messages.UserEvent;

@Component
@KafkaListener(id = "multiGroup", topics = "users")
public class KafkaListenerMessage {

	@KafkaHandler
	public void handleGreeting(Message<UserEvent> mesage) {
		System.out.println("Greeting received: " + mesage);
	}

	@KafkaHandler(isDefault = true)
	public void unknown(Object object) {
		System.out.println("Unkown type received: " + object);
	}
}
