package spring.demo.ulti;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TechnicalException extends RuntimeException {

	public TechnicalException(String exceptionMsg) {
		super(exceptionMsg);
	}
}