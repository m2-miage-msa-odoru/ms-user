package fello.miage.responses;

import fello.miage.enums.RoleMembre;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Schema(description = "L'email du membre")
    private String email;
    @Schema(description = "Nom du membre")
    private String nom;

    @Schema(description = "Prénom du membre")
    private String prenom;

    @Schema(description = "Role du membre")
    private RoleMembre role;

    @Schema(description = "Le niveau d'expertise du membre")
    private Integer niveau_expertise;
}
