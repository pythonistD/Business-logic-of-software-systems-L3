package cheboksarov.blps_lab3.service;

import cheboksarov.blps_lab3.controller.AuthenticationResponse;
import cheboksarov.blps_lab3.dto.AuthenticationRequestDto;
import cheboksarov.blps_lab3.dto.RegisterRequestDto;

public interface AuthenticationService {
    AuthenticationResponse logIn(AuthenticationRequestDto requestDto);
    AuthenticationResponse register(RegisterRequestDto requestDto);
}
