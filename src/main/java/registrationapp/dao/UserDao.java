package registrationapp.dao;

import org.springframework.stereotype.Repository;
import registrationapp.models.User;

/**
 *
 * @author jnap
 */
@Repository
public interface UserDao {

    User findByEmail(String email);

    void save(User user);
}
