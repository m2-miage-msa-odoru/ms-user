package fello.miage.messaging.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpertiseUpdatedEvent {
    private String email;
    private int niveau_expertise;
    private int new_expertise;
    private LocalDateTime date_mis_ajour;
}
