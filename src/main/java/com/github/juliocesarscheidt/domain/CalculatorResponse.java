package com.github.juliocesarscheidt.domain;

public class CalculatorResponse {
	public float value;
	public String kind;

	public CalculatorResponse(float value, String kind) {
		this.value = value;
		this.kind = kind;
	}
}
