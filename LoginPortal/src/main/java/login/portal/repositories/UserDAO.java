package login.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import login.portal.model.User;
import login.portal.model.UserRole;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{
	
	public List<User> getByRole(UserRole role);
	
	public User getUserByUsername(User u);
	
	public User addNewUser(User u);

}
