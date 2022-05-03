package com.raficruz.countandprint;

public class DivisorData {

	private int divisor;
	private String alternativeReturn;

	public DivisorData(int divisor, String alternativeReturn) {
		this.divisor = divisor;
		this.alternativeReturn = alternativeReturn;
	}

	public int getDivisor() {
		return divisor;
	}

	public String getAlternativeReturn() {
		return alternativeReturn;
	}

}
