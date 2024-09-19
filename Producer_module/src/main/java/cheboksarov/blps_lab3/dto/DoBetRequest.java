package cheboksarov.blps_lab3.dto;

import cheboksarov.blps_lab3.model.Credential;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoBetRequest {
    Long matchId;
    String event;
    Integer bet;
    Long credentialId;
}
