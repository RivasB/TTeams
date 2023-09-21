package cloud.tteams.identity.security.domain.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.repository.IUserQueryRepository;
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
    public UserDetails loadUserByUsername(String identification) throws ResponseStatusException {
        UserDetails user = null;
        try {
            Optional<User> appUser = repository.findByIdentification(identification);
            Set<GrantedAuthority> grantList = new HashSet<>();
            String role = "ROLE_" + appUser.get().getType().toString();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
            grantList.add(grantedAuthority);
            user = (UserDetails) new org.springframework.security.core.userdetails.User(
                    appUser.get().getIdentification().value(),
                    appUser.get().getPassword().value(), grantList);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User must be registred");
        }
        return user;
    }
}
