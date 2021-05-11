package com.github.juliocesarscheidt.services;

import jakarta.jws.WebService;
import com.github.juliocesarscheidt.domain.*;

@WebService
public class CalculatorImpl implements Calculator {
	public CalculatorResponse sum(float number1, float number2) {
		return new CalculatorResponse(number1 + number2, "sum");
	}

	public CalculatorResponse subtraction(float number1, float number2) {
		return new CalculatorResponse(number1 - number2, "subtraction");
	}

	public CalculatorResponse multiplication(float number1, float number2) {
		return new CalculatorResponse(number1 * number2, "multiplication");
	}

	public CalculatorResponse division(float number1, float number2) {
		return number2 != 0 ? new CalculatorResponse(number1 / number2, "division") : null;
	}
}
