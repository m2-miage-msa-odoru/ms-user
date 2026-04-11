package fello.miage.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MembreDTO {
    @Schema(description = "L'email du membre")
    private String email;
    @Schema(description = "Nom du membre")
    private String nom;

    @Schema(description = "Prénom du membre")
    private String prenom;

    @Schema(description = "Role du membre")
    private String role;

    @Schema(description = "Le niveau d'expertise du membre")
    private String niveau_expertise;
}
