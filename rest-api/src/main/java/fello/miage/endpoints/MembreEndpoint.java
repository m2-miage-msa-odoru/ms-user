package fello.miage.endpoints;


import fello.miage.requests.MembreResquest;
import fello.miage.responses.MembreDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/membres")
public interface MembreEndpoint {

    @ApiResponse(responseCode = "201", description = "Création réussi")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/")
    MembreDTO createMembre(@RequestBody MembreResquest membreResquest);
}
