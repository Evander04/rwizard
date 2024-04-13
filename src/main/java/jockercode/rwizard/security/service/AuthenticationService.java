package jockercode.rwizard.security.service;

import jockercode.rwizard.security.dao.request.SigninRequest;
import jockercode.rwizard.security.dao.response.JwtAuthenticationResponse;
import jockercode.rwizard.security.dao.request.SignUpRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse signin(SigninRequest request);
}
