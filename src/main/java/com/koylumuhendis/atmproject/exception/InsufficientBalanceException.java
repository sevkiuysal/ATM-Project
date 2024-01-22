package com.koylumuhendis.atmproject.exception;

import org.springframework.stereotype.Component;

@Component
public class InsufficientBalanceException extends RuntimeException {

	public InsufficientBalanceException() {
		super("Insufficient Balance! Please upload money first.");
	}
}
