package registrationapp.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import registrationapp.models.User;

/**
 *
 * @author jnap
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = currentSession.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(builder.equal(root.get("email"), email));
        Query<User> q = currentSession.createQuery(criteria);
        // this line is used to avoid no entity found for query that comes from getSingleResult() exceptions
        User user = (User) q.getResultList().stream().findFirst().orElse(null);
        if (user != null) {
            Hibernate.initialize(user.getRoles());
        }
        return user;

    }

    @Override
    public void save(User user) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(user);
    }
}
