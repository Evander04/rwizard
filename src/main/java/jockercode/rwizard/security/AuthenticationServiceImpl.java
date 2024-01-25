package jockercode.rwizard.security;

import jockercode.rwizard.pojo.UserObj;
import jockercode.rwizard.security.dao.request.SigninRequest;
import jockercode.rwizard.utils.Setup;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import jockercode.rwizard.repository.UserRepository;
import jockercode.rwizard.security.dao.request.SignUpRequest;
import jockercode.rwizard.security.dao.response.JwtAuthenticationResponse;
import jockercode.rwizard.security.service.AuthenticationService;
import jockercode.rwizard.security.service.JwtService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private Setup setup;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        UserObj user= setup.initDB();
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token("Bearer "+jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);

        return JwtAuthenticationResponse.builder()
                .token("Bearer "+jwt)
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole().getCode())
                .build();
    }
}
