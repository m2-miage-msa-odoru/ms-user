package fello.miage.messaging.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange.user-events}")
    private String userEventsExchange;

    @Value("${rabbitmq.routing-key.user-registered}")
    private String userRegisteredRoutingKey;

    @Value("${rabbitmq.routing-key.expertise-updated}")
    private String expertiseUpdatedRoutingKey;

    // ── Queues ──────────────────────────────────────
    @Bean
    public Queue userRegisteredQueue() {
        return new Queue("user.registered.queue", true);
    }

    @Bean
    public Queue expertiseUpdatedQueue() {
        return new Queue("user.expertise.updated.queue", true);
    }

    // ── Exchange ─────────────────────────────────────
    @Bean
    public TopicExchange userEventsExchange() {
        return new TopicExchange(userEventsExchange);
    }

    // ── Bindings ─────────────────────────────────────
    @Bean
    public Binding bindingUserRegistered() {
        return BindingBuilder
                .bind(userRegisteredQueue())
                .to(userEventsExchange())
                .with(userRegisteredRoutingKey);
    }

    @Bean
    public Binding bindingExpertiseUpdated() {
        return BindingBuilder
                .bind(expertiseUpdatedQueue())
                .to(userEventsExchange())
                .with(expertiseUpdatedRoutingKey);
    }

    // ── Converter & Template ──────────────────────────
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}