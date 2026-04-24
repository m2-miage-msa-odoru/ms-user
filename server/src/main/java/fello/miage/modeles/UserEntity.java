package fello.miage.modeles;

import fello.miage.enums.RoleMembre;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @Email
    private String email;

    @NotBlank
    private String prenom;

    @NotBlank
    private String nom;

    @Size(min = 4, max = 12)
    private String mot_de_passe;

    @Enumerated(EnumType.STRING)
    private RoleMembre role;

    @Min(value = 1)
    @Max(value = 5)
    private Integer niveau_expertise;

    @ManyToOne
    private AdresseEntity user_adresse;

}
