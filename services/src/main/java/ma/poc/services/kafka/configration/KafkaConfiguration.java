package ma.poc.services.kafka.configration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import ma.poc.services.kafka.messages.BuisnessEvent;
import ma.poc.services.kafka.messages.Message;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	public Map<String, Object> getConfiguration() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		configs.put(JsonSerializer.TYPE_MAPPINGS, "userEvent:ma.poc.services.kafka.messages.UserEvent, "
				+ "message:ma.poc.services.kafka.messages.Message");
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "multiGroup");
		return configs;
	}

	@Bean
	public KafkaAdmin kafkaAdmin() {
		return new KafkaAdmin(getConfiguration());
	}

	@Bean
	public NewTopic users() {
		return TopicBuilder.name("users").build();
	}

	@Bean
	public ProducerFactory<String, Message<? extends BuisnessEvent>> producerFactory() {
		return new DefaultKafkaProducerFactory<>(getConfiguration());
	}

	@Bean
	public KafkaTemplate<String, Message<? extends BuisnessEvent>> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public ProducerFactory<String, Object> producerObjectFactory() {
		return new DefaultKafkaProducerFactory<>(getConfiguration());
	}

	@Bean
	public KafkaTemplate<String, Object> kafkaObjectTemplate() {
		return new KafkaTemplate<>(producerObjectFactory());
	}

	@Bean
	public ConsumerFactory<String, Message<? extends BuisnessEvent>> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(getConfiguration(), new StringDeserializer(),
				new JsonDeserializer<>(Message.class));
	}

	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Message<? extends BuisnessEvent>>> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Message<? extends BuisnessEvent>> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setConcurrency(2);
		factory.getContainerProperties().setPollTimeout(3000);
		return factory;
	}
}
