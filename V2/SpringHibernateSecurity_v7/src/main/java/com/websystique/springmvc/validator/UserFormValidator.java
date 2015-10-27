package com.websystique.springmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.websystique.springmvc.model.User;

public class UserFormValidator implements Validator {

	// which objects can be validated by this validator
	public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {

		if (obj instanceof User) {
			User user = (User) obj;
			// if(user.getUserId() <=0){
			// errors.rejectValue("id", "negativeValue", new Object[]{"'id'"},
			// "id can't be negative");
			// }

			if (!(user.getEmail().matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")))
				errors.rejectValue("email", "email.wrong",
						new Object[] { "'email'" }, "Email is Wrong");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
					"name.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
					"username.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
					"password.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
					"email.required");

		}
	}
}
