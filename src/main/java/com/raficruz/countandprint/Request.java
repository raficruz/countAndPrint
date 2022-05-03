package com.raficruz.countandprint;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Request {
	private static final String  WRONG_PATTERN = 
			"The configurated pair [{0}, {1}]  could not be loaded. "
			+ "Reason: \"{0}\" should be a number and \"{1}\" should be the message Text";

	private int initialValue;
	private int finalValue;
	private List<DivisorData> dataConfig = new ArrayList<>();

	public Request(String[] args) {
		initialValue = Integer.valueOf(args[0]);
		finalValue = Integer.valueOf(args[1]);
		
		int i = 3;
		while(i < args.length){
			try {
				dataConfig.add(new DivisorData(Integer.parseInt(args[i-1]), args[i]));
			} catch(NumberFormatException nfex){
				// I decided ignore when divisible parameters are wrong
				System.out.println(MessageFormat.format(WRONG_PATTERN, args[i-1], args[i]));
			} finally {
				i = i+2;
			}
		}
	}

	public int getInitialValue() {
		return initialValue;
	}

	public int getFinalValue() {
		return finalValue;
	}

	public List<DivisorData> getDataConfig() {
		return dataConfig;
	}

}
