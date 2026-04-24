package fello.miage.requests;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @Schema(description = "Email du membre (servira d'identifiant unique)")
    @Email(message = "Format email invalide")
    private String email;

    @Schema(description = "Le nom du membre ")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
    private String motDePasse;

    @Schema(description = "Adresse de résidence")
    @Valid
    private AdresseRequest adresse;
}
