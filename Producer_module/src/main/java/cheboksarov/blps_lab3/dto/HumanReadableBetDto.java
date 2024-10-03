package cheboksarov.blps_lab3.dto;

import cheboksarov.blps_lab3.model.Bet;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

@Data
@Builder
public class HumanReadableBetDto {
    Long matchId;
    HashMap<String, String> teams;
    Bet.BetEvent event;
    HashMap<String, Float> coefficient;
    Double amount;
}
