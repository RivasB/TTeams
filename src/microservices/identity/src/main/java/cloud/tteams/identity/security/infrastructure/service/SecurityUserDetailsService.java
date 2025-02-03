package cloud.tteams.identity.security.infrastructure.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.repository.user.IUserQueryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SecurityUserDetailsService implements UserDetailsService {

    private final IUserQueryRepository repository;

    public SecurityUserDetailsService(IUserQueryRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws ResponseStatusException {
        UserDetails user;
        try {
            Optional<User> appUser = repository.findByEmail(email);
            Set<GrantedAuthority> grantList = new HashSet<>();
            if (appUser.isEmpty()) {
                throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "¡Debes registrarte primero!");
            }
            String role = "ROLE_" + appUser.get().getType().toString();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
            grantList.add(grantedAuthority);
            user = new org.springframework.security.core.userdetails.User(
                    appUser.get().getEmail(),
                    appUser.get().getPassword(), grantList);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "¡Debes registrarte primero!");
        }
        return user;
    }
}
