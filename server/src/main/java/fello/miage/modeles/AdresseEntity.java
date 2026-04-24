package fello.miage.modeles;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdresseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String pays;

    @NotBlank
    private String ville;

    @NotNull(message = "Le code postal est obligatoire")
    private Integer codePostal;

    @NotBlank
    private String numero_et_voie;

    private String description;

    @OneToMany(mappedBy = "user_adresse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserEntity> users;


}
