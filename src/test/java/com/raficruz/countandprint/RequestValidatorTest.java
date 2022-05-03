package com.raficruz.countandprint;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.raficruz.countandprint.RequestValidator;

public class RequestValidatorTest {
	String[] emptyArgs;
	String[] successArgs;
	String[] unpairArgs;
	String[] badPatternArgs;
	
	@Before
	public void init() {
		emptyArgs = new String[] {};
		badPatternArgs = new String[] {"ONE","TWENTY"};
		successArgs = new String[] {"1","20"};
		unpairArgs = new String[] {"1","20","2"};
	}

	@Test
	public void whenAnyParameterWasInformed() {
		assertFalse(RequestValidator.validateParameters(emptyArgs));
	}

	@Test
	public void whenJustCountingParametersWasInformed() {
		assertTrue(RequestValidator.validateParameters(successArgs));
	}

	@Test
	public void whenUncompletedParametersWasInformed() {
		assertFalse(RequestValidator.validateParameters(unpairArgs));
	}

	@Test
	public void whenJustCountingParameterInAWrongPatternsWasInformed() {
		assertFalse(RequestValidator.validateParameters(badPatternArgs));
	}
	
//
//	public boolean validateParameters(String[] arguments) {
//		if (ArrayUtils.isEmpty(arguments)) {
//			System.out.println("Nenhum parametro informado!");
//			return false;
//		}
//
//		if (arguments.length % 2 != 0) {
//			System.out.println(
//					"Os parametros informados devem seguir o padrão: "
//					+ "[valor-inicial, valor-final, divisor01, mensagem01, ... ,divisorN, mensagemN]");
//			return false;
//		}
//
//		int initialValue = 0;
//		int finalValue = 0;
//
//		try {
//			initialValue = Integer.parseInt(arguments[0]);
//			finalValue = Integer.parseInt(arguments[1]);
//		} catch (NumberFormatException nfex) {
//			System.out.println("Parâmetros inválidos! Os parametros informados devem seguir o padrão: "
//					+ "[valor-inicial, valor-final, divisor01, mensagem01, ... ,divisorN, mensagemN]");
//			return false;
//		}
//
//		if(initialValue > finalValue) {
//			return false;
//		}
//		
//		return true;
//	}
}
