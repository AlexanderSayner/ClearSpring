/**
 * 
 */
package sayner.sandbox.context.annotated.dao.impl;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sayner.sandbox.context.annotated.dao.UserDao;
import sayner.sandbox.models.impl.CustomUser;

/**
 * @author uarchon
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(CustomUser user) {

		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public Collection<CustomUser> list() {

		@SuppressWarnings("unchecked")
		TypedQuery<CustomUser> query = sessionFactory.getCurrentSession().createQuery("from CustomUser");
		return query.getResultList();
	}

}
