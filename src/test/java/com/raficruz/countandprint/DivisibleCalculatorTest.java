package com.raficruz.countandprint;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.raficruz.countandprint.DivisibleCalculator;
import com.raficruz.countandprint.DivisorData;



public class DivisibleCalculatorTest {

	DivisibleCalculator calculator;
	DivisorData divisibleByZero;
	DivisorData divisibleByTwo;
	DivisorData divisibleByThree;

	@Before
	public void init() {
		calculator = new DivisibleCalculator();
		divisibleByZero = new DivisorData(0, "Hm?");
		divisibleByTwo = new DivisorData(2, "Visual");
		divisibleByThree = new DivisorData(3, "Nuts");
	}

	@Test
	public void whenNumberToBeCheckedEqualsZeroAndDontHaveAnyDivisorData() {
		int numberToBeChecked = 0;
		List<String> expected = Arrays.asList(new String[]{String.valueOf(numberToBeChecked)});
		
		assertThat(calculator.findOutputText(numberToBeChecked, null), is(expected));
	}

	@Test
	public void whenDontHaveAnyDivisorData() {
		int numberToBeChecked = 1;
		List<String> expected = Arrays.asList(new String[]{String.valueOf(numberToBeChecked)});
		
		assertThat(calculator.findOutputText(numberToBeChecked, null), is(expected));
	}

	@Test
	public void whenNumberToBeCheckedIsDivisibleByTwoResponseVisual() {
		int numberToBeChecked = 2;
		List<String> expected = Arrays.asList(new String[]{String.valueOf("Visual")});
		
		assertThat(calculator.findOutputText(numberToBeChecked, Arrays.asList(divisibleByTwo)), is(expected));
	}

	@Test
	public void whenNumberToBeCheckedIsDivisibleByThreeResponseNuts() {
		int numberToBeChecked = 3;
		List<String> expected = Arrays.asList(new String[]{String.valueOf("Nuts")});
		
		assertThat(calculator.findOutputText(numberToBeChecked, Arrays.asList(divisibleByThree)), is(expected));
	}

	@Test
	public void whenNumberToBeCheckedIsDivisibleByTwoAndByThreeResponseVisualNuts() {
		int numberToBeChecked = 6;
		List<String> expected = Arrays.asList(new String[]{"Visual","Nuts"});

		assertThat(calculator.findOutputText(numberToBeChecked, Arrays.asList(new DivisorData[] {divisibleByTwo, divisibleByThree})), is(expected));
	}

	@Test
	public void whenNumberToBeCheckedIsDivisibleByTwoAndNotByThreeResponseVisualNuts() {
		int numberToBeChecked = 8;
		List<String> expected = Arrays.asList(new String[]{"Visual"});

		assertThat(calculator.findOutputText(numberToBeChecked, Arrays.asList(new DivisorData[] {divisibleByTwo, divisibleByThree})), is(expected));
	}

	@Test
	public void whenNumberToBeCheckedIsNotDivisibleByTwoAndIsByThreeResponseVisualNuts() {
		int numberToBeChecked = 9;
		List<String> expected = Arrays.asList(new String[]{"Nuts"});

		assertThat(calculator.findOutputText(numberToBeChecked, Arrays.asList(new DivisorData[] {divisibleByTwo, divisibleByThree})), is(expected));
	}

	@Test
	public void whenNumberToBeCheckedIsZeroHm() {
		int numberToBeChecked = 7;
		List<String> expected = Arrays.asList(new String[]{String.valueOf(numberToBeChecked)});

		assertThat(calculator.findOutputText(numberToBeChecked, Arrays.asList(new DivisorData[] {divisibleByZero, divisibleByTwo, divisibleByThree})), is(expected));
	}

	@Test
	public void whenNumberToBeCheckedIsZeroAndDivisibleByTwoResponseZero() {
		int numberToBeChecked = 0;
		List<String> expected = Arrays.asList(new String[]{"0"});

		assertThat(calculator.findOutputText(numberToBeChecked, Arrays.asList(new DivisorData[] {divisibleByTwo, divisibleByThree})), is(expected));
	}
	
//	public List<String> findOutputText(int numberToBeChecked, List<DivisorData> data) {
//		
//		boolean hasDivisibleFound = false;
//		List<String> outputEntries = new ArrayList<>();
//
//		for(DivisorData currentDivisorData: data) {
//			if ((numberToBeChecked != 0) && 
//				(numberToBeChecked % currentDivisorData.getDivisor() == 0))
//			{
//				hasDivisibleFound = true;
//				outputEntries.add(currentDivisorData.getAlternativeReturn());
//			} else {
//				outputEntries.add(String.valueOf(numberToBeChecked));
//			}
//		}
//
//		if(hasDivisibleFound) {
//			return outputEntries.stream()
//			.filter( e -> !e.matches("-?[0-9]*"))
//			.collect(Collectors.toList());
//		}
//
//		return Stream.of(String.valueOf(numberToBeChecked)).collect(Collectors.toList());
//	}

}
