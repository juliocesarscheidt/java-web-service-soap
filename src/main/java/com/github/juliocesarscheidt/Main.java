package com.github.juliocesarscheidt;

import jakarta.xml.ws.Endpoint;
import com.github.juliocesarscheidt.services.*;
import com.github.juliocesarscheidt.interfaces.CalculatorWS;
import com.github.juliocesarscheidt.interfaces.ItemWS;

public class Main {
  final static String serverHost = "0.0.0.0";
  final static Integer serverPort = 9090;

	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		ClassLoader contextClassLoader = thread.getContextClassLoader();

		try {
			thread.setContextClassLoader(Endpoint.class.getClassLoader());

			String URL = "http://" + serverHost + ":" + serverPort;

			CalculatorWS calcWS = new CalculatorWSImpl();
			ItemWS itemWS = new ItemWSImpl();

			System.out.println("SOAP calculator service running on " + URL);

			Endpoint.publish(URL + "/calculatorWS", calcWS);
			Endpoint.publish(URL + "/itemWS", itemWS);

		} finally {
			thread.setContextClassLoader(contextClassLoader);
		}
	}
}
