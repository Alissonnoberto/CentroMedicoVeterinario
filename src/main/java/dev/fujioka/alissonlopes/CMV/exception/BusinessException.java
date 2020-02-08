package dev.fujioka.alissonlopes.CMV.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author alisson
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BusinessException extends RuntimeException {
	private String personName;
	private String fieldName;
	private Object fieldValue;

	public BusinessException(String personName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", personName, fieldName, fieldValue));
		this.personName = personName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getPersonName() {
		return personName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}
}
