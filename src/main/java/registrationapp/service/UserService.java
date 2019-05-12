package registrationapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import registrationapp.models.CrmUser;
import registrationapp.models.User;

/**
 *
 * @author jnap
 */
public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    void save(CrmUser registration);
}
