package fello.miage.requests;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembreResquest {
    @Schema(description = "Le mail du membre")
    @Email(message = "Respect le format de l'email")
    @NotBlank(message = "Le mail est obligatoire")
    private String email;

    @Schema(description = "Nom du membre")
    private String nom;
    @Schema(description = "Prenom du membre")
    private String prenom;


}
