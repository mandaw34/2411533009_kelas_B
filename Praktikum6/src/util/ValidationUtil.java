package util;

import error.ValidationException;
import Model.User;

public class ValidationUtil {
	
	public static void validate(User user) throws ValidationException, NullPointerException{
		if(user.getUsername() == null) {
			throw new NullPointerException("Username is null");
		}
		else if(user.getUsername().isBlank()) {
			throw new ValidationException("Username is blank");
		}
		else if(user.getPassword() == null) {
			throw new NullPointerException("Passwordn is null");
		}
		else if(user.getPassword().isBlank()) {
			throw new ValidationException("Password is Blank");
		}
	}

}
