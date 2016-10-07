package com.occ.exercise.namestest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.occ.exercise.namestest.domain.Name;

public class NamesScoringServiceImplTest {
	
	NamesScoringServiceImpl target = new NamesScoringServiceImpl();
	
	@Test
    public void getSortedNamesFromFileStream() {
		Stream<String> fileStream = Arrays.asList("\"MARY\",\"YEE\",\"TIANNA\",\"AARON\",\"ALEIDA\"").stream();
		List<Name> names = target.getSortedNamesFromFileStream(fileStream);
		assertEquals(5, names.size());
		assertFalse(names.get(0).getFirstName().contains("\""));
		assertTrue(names.get(0).getFirstName().equals("AARON"));
		assertTrue(names.get(1).getFirstName().equals("ALEIDA"));
		assertTrue(names.get(2).getFirstName().equals("MARY"));
		assertTrue(names.get(3).getFirstName().equals("TIANNA"));
		assertTrue(names.get(4).getFirstName().equals("YEE"));
    }
	
	@Test
	public void getNamesScore() {
		Stream<String> fileStream = Arrays.asList("\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"").stream();
		
		assertEquals(3194, target.getNamesScore(fileStream, "department1"));
	}

	@Test
	public void getNameScore() {
		Name name = new Name("LINDA");
		assertEquals(40, target.getNameScore(name, "department1"));
	}
	
	@Test
	public void getNumberOfProcessors() {
		System.out.println(Runtime.getRuntime().availableProcessors());
	}


}
