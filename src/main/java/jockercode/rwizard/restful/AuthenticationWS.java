package jockercode.rwizard.restful;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jockercode.rwizard.security.dao.request.SigninRequest;
import jockercode.rwizard.security.dao.response.JwtAuthenticationResponse;
import jockercode.rwizard.security.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Log
public class AuthenticationWS {
        private final AuthenticationService aService;

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(aService.signin(request));
    }
}
