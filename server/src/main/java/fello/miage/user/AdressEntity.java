package fello.miage.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdressEntity {
    @Id
    private String id;
    private String ville;
    private int codePostal;
    private String rue;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private MembreEntity user;


}
