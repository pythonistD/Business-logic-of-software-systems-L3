package cheboksarov.blps_lab3.service;

import cheboksarov.blps_lab3.model.Credential;

public interface CredentialService {
    Credential registerNewUser(Credential credential);

    Credential findByUserName(String username) throws Exception;
}
