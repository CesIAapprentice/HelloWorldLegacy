package net.java.spring.connection;
import net.java.spring.User;

public interface UserDao {
	   User getUser(String username);
	   boolean insertUser(User user);
	   boolean isUserInDatabase(String username);
	   boolean isLoginCorrect(String username, String password);
}
