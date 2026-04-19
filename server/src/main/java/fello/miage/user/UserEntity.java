package fello.miage.user;

import fello.miage.enums.RoleMembre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private String email;
    private String prenom;
    private String nom;
    private String mot_de_passe;
    @Enumerated(EnumType.STRING)
    private RoleMembre role;
    private int niveau_expertise;

    @ManyToOne
    private AdressEntity user_adresse;

}
