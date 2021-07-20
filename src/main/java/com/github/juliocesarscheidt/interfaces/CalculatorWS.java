package com.github.juliocesarscheidt.interfaces;

import com.github.juliocesarscheidt.domain.Calculator;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface CalculatorWS {
  @WebMethod Calculator sum(float number1, float number2);
  @WebMethod Calculator subtraction(float number1, float number2);
  @WebMethod Calculator multiplication(float number1, float number2);
  @WebMethod Calculator division(float number1, float number2);
}
