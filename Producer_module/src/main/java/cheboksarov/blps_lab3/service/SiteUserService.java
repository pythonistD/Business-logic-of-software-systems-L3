package cheboksarov.blps_lab3.service;

import cheboksarov.blps_lab3.model.Credential;
import cheboksarov.blps_lab3.model.SiteUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SiteUserService {
    SiteUser createNewUser(SiteUser siteUser);

    List<SiteUser> getAllUsers();

    SiteUser findUserById(Long userId);

    ResponseEntity<?> makePayment(Double amount, String username) throws Exception;

    SiteUser findByCredentialId(Credential credential) throws Exception;

    ResponseEntity<?> getMyBalance();
}
