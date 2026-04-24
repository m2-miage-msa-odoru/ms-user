package fello.miage.messaging.producer;

import fello.miage.messaging.events.ExpertiseUpdatedEvent;
import fello.miage.messaging.events.UserRegisteredEvent;
import fello.miage.modeles.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RabbitMQProducer {

    private final AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange.user-events}")
    private String userEventsExchange;

    @Value("${rabbitmq.routing-key.user-registered}")
    private String userRegisteredRoutingKey;

    @Value("${rabbitmq.routing-key.expertise-updated}")
    private String expertiseUpdatedRoutingKey;

    public void publishUserRegistered(UserEntity user) {
        UserRegisteredEvent event = UserRegisteredEvent.builder()
                .email(user.getEmail())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .niveau_expertise(user.getNiveau_expertise())
                .role(user.getRole())
                .dateInscription(LocalDateTime.now())
                .build();

        amqpTemplate.convertAndSend(
                userEventsExchange,
                userRegisteredRoutingKey,
                event
        );
    }

    public void publishExpertiseUpdated(UserEntity user, int niveau_expertise) {
        ExpertiseUpdatedEvent event = ExpertiseUpdatedEvent.builder()
                .email(user.getEmail())
                .niveau_expertise(niveau_expertise)
                .new_expertise(user.getNiveau_expertise())
                .date_mis_ajour(LocalDateTime.now())
                .build();

        amqpTemplate.convertAndSend(
                userEventsExchange,
                expertiseUpdatedRoutingKey,
                event
        );
    }
}