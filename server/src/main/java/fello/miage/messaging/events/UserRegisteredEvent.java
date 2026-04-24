package fello.miage.messaging.events;

import fello.miage.enums.RoleMembre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisteredEvent {
    private String email;
    private String nom;
    private String prenom;
    private int niveau_expertise;
    private RoleMembre role;
    private LocalDateTime dateInscription;
}