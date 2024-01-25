package jockercode.rwizard.security.dao.response;

import jockercode.rwizard.pojo.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String token;
    private String username;
    private String email;
    private String role;
}
