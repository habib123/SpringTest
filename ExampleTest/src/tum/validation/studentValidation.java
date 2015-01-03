package tum.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import tum.spring.Student;


@Component
public class studentValidation implements Validator {
	
	private final static String STUDENT_PASSWORD = "password";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student) target;
		
		String studentName = student.getName();
		
		ValidationUtils.rejectIfEmpty(errors, "name", "student.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "student.password.empty");
		
		if (studentName != null && STUDENT_PASSWORD.length() < 5)
			errors.rejectValue(STUDENT_PASSWORD, "shop.emplNumber.lessThenOne");

	}

}
