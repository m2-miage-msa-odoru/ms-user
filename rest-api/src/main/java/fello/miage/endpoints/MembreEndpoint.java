package fello.miage.endpoints;


import fello.miage.requests.UserResquest;
import fello.miage.responses.UserDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/membres")
public interface MembreEndpoint {

    @ApiResponse(responseCode = "201", description = "Création réussi")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/")
    UserDTO createMembre(@RequestBody UserResquest userResquest);
}
