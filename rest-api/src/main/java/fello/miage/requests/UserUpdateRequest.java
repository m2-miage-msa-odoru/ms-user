package fello.miage.requests;

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
public class UserUpdateRequest {
    @Schema(description = "Le role du membre a mettre a jour")
    private RoleMembre role;
    @Schema(description = "le niveau expertise a mettre à jour")
    private Integer niveau_expertise;

}
