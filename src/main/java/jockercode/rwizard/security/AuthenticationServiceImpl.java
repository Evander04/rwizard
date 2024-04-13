package jockercode.rwizard.security;

import jockercode.rwizard.pojo.UserObj;
import jockercode.rwizard.security.dao.request.SigninRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import jockercode.rwizard.repository.UserRepository;
import jockercode.rwizard.security.dao.response.JwtAuthenticationResponse;
import jockercode.rwizard.security.service.AuthenticationService;
import jockercode.rwizard.security.service.JwtService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        UserSecurity userSecurity = new UserSecurity();
        UserObj obj=userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        userSecurity.setUsername(obj.getUsername());
        userSecurity.setPassword(obj.getPassword());
        userSecurity.setRole(obj.getRole());
        userSecurity.setEmail(obj.getEmail());
        userSecurity.setStatus(obj.isStatus());

        var jwt = jwtService.generateToken(userSecurity);

        return JwtAuthenticationResponse.builder()
                .token("Bearer "+jwt)
                .username(userSecurity.getUsername())
                .email(userSecurity.getEmail())
                .role(userSecurity.getRole().getCode())
                .build();
    }
}
