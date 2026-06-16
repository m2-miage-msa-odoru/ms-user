package fello.miage.endpoints;


import fello.miage.enums.RoleMembre;
import fello.miage.requests.LoginRequest;
import fello.miage.requests.UserRequest;
import fello.miage.responses.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/membres")
public interface UserEndpoint {

    @ApiResponse(responseCode = "201", description = "Création réussi")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/")
    UserDTO createMembre(@RequestBody UserRequest userRequest);


    @Operation(description = "Met à jour un adhérent (rôle et/ou niveau d'expertise). "
            + "Opération réservée à la SECRETAIRE : son email est fourni et son rôle est vérifié.")
    @ApiResponse(responseCode = "200", description = "Mise à jour réussie")
    @ApiResponse(responseCode = "403", description = "Seule une secrétaire est autorisée à modifier un adhérent")
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/{email}")
    UserDTO updateMembre(@PathVariable(name = "email") String email,
                         @RequestParam("secretaire_email") String secretaireEmail,
                         @RequestParam(value = "roleMembre", required = false) RoleMembre roleMembre,
                         @RequestParam(value = "niveau_expertise", required = false, defaultValue = "0") int niveau_expertise);

    @Operation(description = " Prise okay")
    @ApiResponse(responseCode = "200", description = "La recuperation à  réussi")
    @ApiResponse(   responseCode = "500", description = "Echec de la mise à jour du tache")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/")
    Iterable<UserDTO> getAllUsers ();

    @Operation(description = "Connexion d'un membre par email + mot de passe")
    @ApiResponse(responseCode = "200", description = "Connexion réussie")
    @ApiResponse(responseCode = "400", description = "Identifiants invalides")
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping("/login")
    UserDTO login(@RequestBody LoginRequest loginRequest);

    @Operation(description = "Récupère un membre par son email")
    @ApiResponse(responseCode = "200", description = "Membre trouvé")
    @ApiResponse(responseCode = "404", description = "Membre introuvable")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{email}")
    UserDTO getMembreByEmail(@PathVariable(name = "email") String email);
}
