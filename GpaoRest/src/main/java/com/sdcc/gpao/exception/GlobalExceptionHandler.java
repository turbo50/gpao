package com.sdcc.gpao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * The type Global exception handler.
 *
 * @author ladac
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Resource not found exception response entity.
   *
   * @param ex the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
    ErrorResponse errorDetails =
        new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(NoDuplicationException.class)
  public ResponseEntity<?> duplicationException(NoDuplicationException ex, WebRequest request) {
    ErrorResponse errorDetails =
        new ErrorResponse(new Date(), HttpStatus.FOUND.toString(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.FOUND);
  }
  
  /**
   * Global exception handler response entity.
   *
   * @param ex the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
	  //Traitement du forbidden
	  if(ex.getMessage().equals("Access is denied")){
		  return forbiddenException(ex, request);
	  }
    ErrorResponse errorDetails =
        new ErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString() ,ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  public ResponseEntity<?> forbiddenException(Exception ex, WebRequest request) {
	    ErrorResponse errorDetails =
	        new ErrorResponse(new Date(), HttpStatus.FORBIDDEN.toString(), "Vous n'avez pas les privilèges pour acceder à ce service", request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
  }
}
