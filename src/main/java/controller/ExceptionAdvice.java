package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理类
 * @author 30038737
 *
 */
@ControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(ArithmeticException.class)
	public String arithmetic(Exception e) {
		return "error/arithmetic";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String nullPointer(Exception e) {
		return "error/nullPointer";
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e) {
		return "error/exception";
	}
}
