package org.assignment.app.controller.api.handler;

import org.assignment.common.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author phuongnq 
 * RestResponseEntityExceptionHandler
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	MessageSource messageSource;

	/**
	 * handleBusinessException
	 * @param ex
	 * @param request
	 * @return HttpStatus.CONFLICT
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleBusinessException(Exception ex, WebRequest request) {
		return handleResultMessagesNotificationException(ex, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleExceptionInternal(java.lang.Exception, java.lang.Object, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
	 */
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		Object responseBody = body;
		if (body == null) {
			responseBody = createApiError(request, "E999", ex.getMessage());
		}
		return ResponseEntity.status(status).headers(headers).body(responseBody);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.springframework.web.bind.MethodArgumentNotValidException, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiError apiError = createApiError(request, "E400");
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			apiError.addDetail(createApiError(request, fieldError, fieldError.getField()));
		}
		for (ObjectError objectError : ex.getBindingResult().getGlobalErrors()) {
			apiError.addDetail(createApiError(request, objectError, objectError.getObjectName()));
		}
		return handleExceptionInternal(ex, apiError, headers, status, request);
	}

	/**
	 * createApiError
	 * @param request
	 * @param errorCode
	 * @param args
	 * @return Json errors
	 * @throws NoSuchMessageException
	 */
	private ApiError createApiError(WebRequest request, String errorCode, Object... args) throws NoSuchMessageException{
		return new ApiError(errorCode, messageSource.getMessage(errorCode, args, request.getLocale()));
	}

	/**
	 * createApiError
	 * @param request
	 * @param messageSourceResolvable
	 * @param target
	 * @return Json errors
	 */
	private ApiError createApiError(WebRequest request, DefaultMessageSourceResolvable messageSourceResolvable,
			String target) {
		return new ApiError(messageSourceResolvable.getCode(),
				messageSource.getMessage(messageSourceResolvable, request.getLocale()), target);
	}

	/**
	 * handleResultMessagesNotificationException
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return return ResponseEntity<Object>
	 */
	private ResponseEntity<Object> handleResultMessagesNotificationException(Exception ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiError apiError = createApiError(request, ex.getMessage());
		return handleExceptionInternal(ex, apiError, headers, status, request);
	}

}
