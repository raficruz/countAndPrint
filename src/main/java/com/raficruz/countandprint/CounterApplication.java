package com.raficruz.countandprint;

public class CounterApplication {

	public static void main(String[] args) {
		if(!RequestValidator.validateParameters(args)) {
			return;
		}

		Request request = new Request(args);

		OutputPrinter.printResult(request);
	}

}
