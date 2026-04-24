package fello.miage.requests;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdresseRequest {
    @Schema(description = "Pays de residence")
    private String pays;
    @Schema(description = "Ville de residence d'un membre")
    private String ville;
    @Schema(description = "Code postal d'un membre on considère uniquement les adresses en France")
    private int codePostal;
    @Schema(description = "Numero et nom de la voie")
    private String numero_et_voie;
    @Schema(description = "Adresse complementaire, ou description complementaire")
    private String description;
}
