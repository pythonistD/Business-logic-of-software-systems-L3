package cheboksarov.blps_lab3.service.impl;

import cheboksarov.blps_lab3.model.Credential;
import cheboksarov.blps_lab3.repository.CredentialRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@NoArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.error("My User Detail Service:" + username);
        Optional<Credential> user = credentialRepository.findByUserName(username);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    }
}
