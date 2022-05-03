package com.raficruz.countandprint;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.raficruz.countandprint.OutputPrinter;
import com.raficruz.countandprint.Request;

public class OutputPrinterTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	private String[] successArgs;
	private String[] completeSuccessArgs;
	private String[] manySuccessArgs;

	@Before
	public void init() {
	    System.setOut(new PrintStream(outContent));
	    successArgs = new String[] {"1","5"};
	    completeSuccessArgs = new String[] {"1","5","2","Texto"};
	    manySuccessArgs = new String[] {"1","5","1","UM","2","DOIS","3","TRES","5","CINCO"};
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}	



	@Test
	public void whenAnyDivisibleChangeWasNotInformed() {
		OutputPrinter.printResult(new Request(successArgs));
		assertEquals("1, 2, 3, 4, 5", outContent.toString().replaceAll("\\r","").replaceAll("\\n",""));
	}

	@Test
	public void whenADivisibleChangeWasInformed() {
		OutputPrinter.printResult(new Request(completeSuccessArgs));
		assertEquals("1, Texto, 3, Texto, 5", outContent.toString().replaceAll("\\r","").replaceAll("\\n",""));
	}

	@Test
	public void whenMoreThanOneDivisibleChangeWasInformed() {
		OutputPrinter.printResult(new Request(manySuccessArgs));
		assertEquals("UM, UM DOIS, UM TRES, UM DOIS, UM CINCO", outContent.toString().replaceAll("\\r","").replaceAll("\\n",""));
	}
	
//	public static void printResult(Request request) {
//		DivisibleCalculatorTest calculator = new DivisibleCalculatorTest();
//		
//		StringBuilder sb = new StringBuilder();
//		
//		for (int i = request.getInitialValue(); i <= request.getFinalValue(); i++) {
//			List<String> entry = calculator.findOutputText(i, request.getDataConfig());
//			if(i != request.getInitialValue()) {
//				sb.append(",");
//			}
//			for (int j = 0; j < entry.size(); j++) {
//				sb.append(" ");
//				sb.append(entry.get(j));
//			}
//		}
//		System.out.println(sb.toString().trim());
//	}

}
