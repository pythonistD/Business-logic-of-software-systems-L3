package cheboksarov.blps_lab3.service;

import cheboksarov.blps_lab3.model.Coefficient;
import cheboksarov.blps_lab3.model.Match;

import java.util.List;

public interface MatchService {
    List<Match> findAllMatch();
    Match saveMatch(Match match);
    Match findById(Long id);
    Match updateMatch(Match match);
    void deleteMatch(Long match_id);
    Match findMatchByCoefficient(Coefficient coefficient);
}
