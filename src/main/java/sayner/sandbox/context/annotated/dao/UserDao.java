/**
 * 
 */
package sayner.sandbox.context.annotated.dao;

import java.util.Collection;

import sayner.sandbox.models.impl.CustomUser;

/**
 * @author uarchon
 *
 */
public interface UserDao {

	void save(CustomUser user);

	Collection<CustomUser> list();
}
