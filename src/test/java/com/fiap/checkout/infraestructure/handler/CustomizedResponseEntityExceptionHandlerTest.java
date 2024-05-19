package com.fiap.checkout.infraestructure.handler;

import com.fiap.checkout.core.domain.exception.ExceptionResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomizedResponseEntityExceptionHandlerTest {

	@InjectMocks
	private CustomizedResponseEntityExceptionHandler exceptionHandler;

	@Mock
	private Exception exception;

	@Mock
	private WebRequest webRequest;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testHandlerAllExceptions() {
		String errorMessage = "Test error message";
		String requestDescription = "Test request description";

		when(exception.getMessage()).thenReturn(errorMessage);
		when(webRequest.getDescription(false)).thenReturn(requestDescription);

		ResponseEntity<ExceptionResponse> response = exceptionHandler.handlerAllExceptions(exception, webRequest);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		assertEquals(errorMessage, response.getBody().getMessage());
	}

	@Test
	public void testHandlerAllExceptionsWithNullMessage() {
		when(exception.getMessage()).thenReturn(null);
		when(webRequest.getDescription(false)).thenReturn("Test request description");

		ResponseEntity<ExceptionResponse> response = exceptionHandler.handlerAllExceptions(exception, webRequest);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		assertEquals(null, response.getBody().getMessage());
	}

	@Test
	public void testHandlerAllExceptionsWithEmptyDescription() {
		when(exception.getMessage()).thenReturn("Test error message");
		when(webRequest.getDescription(false)).thenReturn("");

		ResponseEntity<ExceptionResponse> response = exceptionHandler.handlerAllExceptions(exception, webRequest);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		assertEquals("Test error message", response.getBody().getMessage());
	}
}