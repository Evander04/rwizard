package jockercode.rwizard.security;

import jockercode.rwizard.pojo.UserObj;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jockercode.rwizard.repository.UserRepository;
import jockercode.rwizard.security.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                UserSecurity userSecurity = new UserSecurity();
                UserObj obj=userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));

                userSecurity.setUsername(obj.getUsername());
                userSecurity.setPassword(obj.getPassword());
                userSecurity.setRole(obj.getRole());
                userSecurity.setEmail(obj.getEmail());

                return userSecurity;
            }
        };
    }
}
