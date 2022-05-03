package com.raficruz.countandprint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.ListUtils;

public class DivisibleCalculator {

	public List<String> findOutputText(int numberToBeChecked, List<DivisorData> data) {
		if(numberToBeChecked == 0) {
			return Stream.of(String.valueOf(numberToBeChecked)).collect(Collectors.toList());
		}
		
		boolean hasDivisibleFound = false;
		List<String> outputEntries = new ArrayList<>();

		for(DivisorData currentDivisorData: ListUtils.emptyIfNull(data)) {
			if(currentDivisorData.getDivisor() == 0) {
				continue;
			}
			if (numberToBeChecked % currentDivisorData.getDivisor() == 0)
			{
				hasDivisibleFound = true;
				outputEntries.add(currentDivisorData.getAlternativeReturn());
			} else {
				outputEntries.add(String.valueOf(numberToBeChecked));
			}
		}

		if(hasDivisibleFound) {
			return outputEntries.stream()
			.filter( e -> !e.matches("-?[0-9]*"))
			.collect(Collectors.toList());
		}

		return Stream.of(String.valueOf(numberToBeChecked)).collect(Collectors.toList());
	}

}
