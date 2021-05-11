package com.github.juliocesarscheidt.domain;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface Calculator {
  @WebMethod CalculatorResponse sum(float number1, float number2);
  @WebMethod CalculatorResponse subtraction(float number1, float number2);
  @WebMethod CalculatorResponse multiplication(float number1, float number2);
  @WebMethod CalculatorResponse division(float number1, float number2);
}
