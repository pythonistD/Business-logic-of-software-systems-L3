package cheboksarov.blps_lab3.service;

import cheboksarov.blps_lab3.dto.DoBetDto;
import cheboksarov.blps_lab3.dto.HumanReadableBetDto;
import cheboksarov.blps_lab3.model.Bet;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BetService {
    List<HumanReadableBetDto> findAllMyBets() throws Exception;

    ResponseEntity<?> doBet(DoBetDto doBetDto) throws Exception;
}
