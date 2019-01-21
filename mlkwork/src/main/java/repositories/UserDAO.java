package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import beans.User;
import beans.UserRole;

public interface UserDAO extends JpaRepository<User, Integer> {
	
	

	public User GetByUsername(String username);
}
