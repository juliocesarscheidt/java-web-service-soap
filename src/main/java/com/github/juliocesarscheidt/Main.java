package com.github.juliocesarscheidt;

import jakarta.xml.ws.Endpoint;
import com.github.juliocesarscheidt.services.*;
import com.github.juliocesarscheidt.domain.*;

public class Main {
  final static String serverHost = "0.0.0.0";
  final static Integer serverPort = 8090;

	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		ClassLoader contextClassLoader = thread.getContextClassLoader();

		try {
			thread.setContextClassLoader(Endpoint.class.getClassLoader());

			Calculator calc = new CalculatorImpl();
      String URL = "http://" + serverHost + ":" + serverPort + "/calculator";

      System.out.println("SOAP calculator service running on " + URL);

      Endpoint.publish(URL, calc);

		} finally {
			thread.setContextClassLoader(contextClassLoader);
		}
	}
}
