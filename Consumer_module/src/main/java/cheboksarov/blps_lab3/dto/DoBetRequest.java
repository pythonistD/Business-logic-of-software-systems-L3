package cheboksarov.blps_lab3.dto;

import cheboksarov.blps_lab3.model.Credential;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoBetRequest {
    Long matchId;
    String event;
    Double bet;
    Long credentialId;
}
