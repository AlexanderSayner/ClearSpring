/**
 * 
 */
package sayner.sandbox.context.annotated.services.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sayner.sandbox.context.annotated.dao.UserDao;
import sayner.sandbox.context.annotated.services.UserService;
import sayner.sandbox.models.CustomUser;

/**
 * @author uarchon
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	/**
	 * @param userDao
	 */
	@Autowired
	public UserServiceImpl(UserDao userDao) {

		this.userDao = userDao;
	}

	@Override
	@Transactional
	public void save(CustomUser user) {

		userDao.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CustomUser> list() {

		return userDao.list();
	}

}
