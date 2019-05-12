package registrationapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import registrationapp.models.User;

/**
 *
 * @author jnap
 */

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	User findByEmail(String email);
}