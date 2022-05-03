package com.raficruz.countandprint;

import org.apache.commons.lang3.ArrayUtils;

public class RequestValidator {
	private static final String BAD_PATTERN = "Os parametros informados devem seguir o padrão: [int valorInicial, int valorFinal, int divisor01, String mensagem01, ... ,int divisorN, String mensagemN]";
	private static final String NENHUM_PARAMETRO_INFORMADO = "Nenhum parametro informado!";

	private RequestValidator() {
		super();
	}
	
	public static boolean validateParameters(String[] arguments) {
		if (ArrayUtils.isEmpty(arguments)) {
			System.out.println(NENHUM_PARAMETRO_INFORMADO);
			return false;
		}

		if (arguments.length % 2 != 0) {
			System.out.println(BAD_PATTERN);
			return false;
		}

		try {
			Integer.parseInt(arguments[0]);
			Integer.parseInt(arguments[1]);
		} catch (NumberFormatException nfex) {
			System.out.println(BAD_PATTERN);
			return false;
		}

		return true;
	}
}
