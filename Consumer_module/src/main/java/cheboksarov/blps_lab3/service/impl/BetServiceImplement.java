package cheboksarov.blps_lab3.service.impl;

import cheboksarov.blps_lab3.deserializer.DoBetRequestDeserializer;
import cheboksarov.blps_lab3.dto.DoBetRequest;
import cheboksarov.blps_lab3.model.*;
import cheboksarov.blps_lab3.repository.BetRepository;
import cheboksarov.blps_lab3.repository.CredentialRepository;
import cheboksarov.blps_lab3.service.BetService;
import cheboksarov.blps_lab3.service.CredentialService;
import cheboksarov.blps_lab3.service.MatchService;
import cheboksarov.blps_lab3.service.SiteUserService;
import cheboksarov.blps_lab3.utils.BetUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class BetServiceImplement implements BetService {
    private BetRepository betRepository;
    private SiteUserService userService;
    private MatchService matchService;
    private CredentialService credentialService;
    private CredentialRepository credentialRepository;
    @Override
    public List<Bet> findAllMyBets() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails;
        if (auth.isAuthenticated()){
            userDetails = (UserDetails) auth.getPrincipal();
            log.info("User details: " + userDetails);
        } else {
            throw new UsernameNotFoundException("Wrong userId provided!");
        }
        Credential credential = credentialService.findByUserName(userDetails.getUsername());
        SiteUser siteUser = userService.findByCredentialId(credential);
        //SiteUser user = userService.findUserById(userId);
        return betRepository.findAllBySiteUser(siteUser);
    }

    @Component
    public class KafkaListeners{

        @KafkaListener(
                topics="do_bet_request_topic",
                groupId="consumer_do_bet"
        )
        public void listenerDoBet(String data){
            log.warn("Object from Producer: " + data);
            DoBetRequestDeserializer doBetRequestDeserializer = new DoBetRequestDeserializer(data);
            try {
                DoBetRequest doBetRequest = doBetRequestDeserializer.deserialize();
                doBet(doBetRequest);
            }catch (Exception e){
                log.warn(e.getMessage());
            }
        }
    }



    @Override
    @Transactional
    public ResponseEntity<?> doBet(DoBetRequest doBetRequest) throws Exception {
        if((doBetRequest.getMatchId() == null) | (doBetRequest.getBet() == null)
            | (doBetRequest.getEvent() == null)
                )
        {
            throw new Exception("Bad request data");
        }
        Match match = matchService.findById(doBetRequest.getMatchId());
        Credential credential = credentialRepository.getReferenceById(doBetRequest.getCredentialId());
        SiteUser user = userService.findByCredentialId(credential);
        if (user.getBalance() < doBetRequest.getBet()){
            throw new Exception("Not enought money in your balance ((");
        }
        user.setBalance(user.getBalance()- doBetRequest.getBet());
        Bet.BetEvent event = BetUtils.validateEventString(doBetRequest.getEvent());
        Coefficient coefficient = match.getCoefficient();
        //errorSimulation();
        Bet bet = Bet.builder().siteUser(user).betEvent(event)
                .coefficient(coefficient).build();
        betRepository.save(bet);
        return new ResponseEntity<>("Your bet is accepted!", HttpStatus.OK);

    }

    public void errorSimulation(){
        throw new RuntimeException("Simulated error");
    }
}
