package com.raficruz.countandprint;

import java.util.List;

public class OutputPrinter {
	
	private OutputPrinter() {
		super();
	}

	public static void printResult(Request request) {
		DivisibleCalculator calculator = new DivisibleCalculator();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = request.getInitialValue(); i <= request.getFinalValue(); i++) {
			List<String> entry = calculator.findOutputText(i, request.getDataConfig());
			if(i != request.getInitialValue()) {
				sb.append(",");
			}
			for (int j = 0; j < entry.size(); j++) {
				sb.append(" ");
				sb.append(entry.get(j));
			}
		}
		System.out.println(sb.toString().trim());
	}

}
