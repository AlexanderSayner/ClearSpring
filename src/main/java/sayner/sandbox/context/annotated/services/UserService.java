/**
 * 
 */
package sayner.sandbox.context.annotated.services;

import java.util.Collection;

import sayner.sandbox.models.CustomUser;

/**
 * @author uarchon
 *
 */
public interface UserService {

	void save(CustomUser user);
	 
    Collection<CustomUser> list();
}
