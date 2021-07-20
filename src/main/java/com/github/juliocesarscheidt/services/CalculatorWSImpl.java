package com.github.juliocesarscheidt.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import com.github.juliocesarscheidt.domain.Calculator;
import com.github.juliocesarscheidt.interfaces.CalculatorWS;

@WebService
public class CalculatorWSImpl implements CalculatorWS {
	
	@WebMethod(operationName="sum")
	@WebResult(name="sum")
	public Calculator sum(float number1, float number2) {
		return new Calculator(number1 + number2, "sum");
	}
	
	@WebMethod(operationName="subtraction")
	@WebResult(name="subtraction")
	public Calculator subtraction(float number1, float number2) {
		return new Calculator(number1 - number2, "subtraction");
	}

	@WebMethod(operationName="multiplication")
	@WebResult(name="multiplication")
	public Calculator multiplication(float number1, float number2) {
		return new Calculator(number1 * number2, "multiplication");
	}

	@WebMethod(operationName="division")
	@WebResult(name="division")
	public Calculator division(float number1, float number2) {
		return number2 != 0 ? new Calculator(number1 / number2, "division") : null;
	}
}
