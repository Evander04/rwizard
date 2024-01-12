package security.service;

import security.dao.request.SignUpRequest;
import security.dao.request.SigninRequest;
import security.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
