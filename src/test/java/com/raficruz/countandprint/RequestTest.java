package com.raficruz.countandprint;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.raficruz.countandprint.DivisorData;
import com.raficruz.countandprint.Request;

public class RequestTest {

	private String[] successArgs;
	private String[] completeSuccessArgs;
	private String[] mixedSuccessArgs;
	private List<DivisorData> dataConfig;
	
	@Before
	public void init() {
		successArgs = new String[] {"1","20"};
		completeSuccessArgs = new String[] {"1","20","2","Texto"};
		mixedSuccessArgs = new String[] {"1","20","DOIS","2", "3", "TRES"};
	}

	@Test
	public void whenEverythingIsFine() {
		Request r = new Request(successArgs);
		dataConfig = Stream.of(new DivisorData(2, "Texto")).collect(Collectors.toList());

		assertEquals(1, r.getInitialValue());
		assertEquals(20, r.getFinalValue());
		assertThat(new ArrayList<DivisorData>(), is(r.getDataConfig()));
	}

	@Test
	public void whenEverythingIsFineButWeHaveDivisibles() {
		Request r = new Request(completeSuccessArgs);
		dataConfig = Stream.of(new DivisorData(3, "TRES")).collect(Collectors.toList());

		assertEquals(1, r.getInitialValue());
		assertEquals(20, r.getFinalValue());
		assertEquals(dataConfig.size(), r.getDataConfig().size());
	}


	@Test
	public void whenWeHaveDivisibleParametersWrong() {
		Request r = new Request(mixedSuccessArgs);
		dataConfig = Stream.of(new DivisorData(2, "Texto")).collect(Collectors.toList());

		assertEquals(1, r.getInitialValue());
		assertEquals(20, r.getFinalValue());
		assertEquals(dataConfig.size(), r.getDataConfig().size());
	}
}
