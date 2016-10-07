package com.occ.exercise.namestest.service;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import com.occ.exercise.namestest.domain.Name;
import com.occ.exercise.namestest.strategy.NameScoringStrategy;

public class NamesScoringServiceImpl implements NamesScoringService {
	final static Map<String, NameScoringStrategy> map = new HashMap<>();
	static {
		map.put("department1", ((Name name) -> Lists.charactersOf(name.getNameForScoring()).stream()
																				.map(ch -> (int)ch)
																				.reduce(0, (a, b) -> a + b - 64)));
	}

	@Override
	public int getNamesScore(Stream<String> fileStream, String department) {    	
		List<Name> names = getSortedNamesFromFileStream(fileStream);   	
		return getNamesScore(names, department);
	}
	
	@Override
	public int getNamesScore(List<Name> names, String department) {
		return names.parallelStream()
					.mapToInt(name -> getNameScore(name, department) * (names.indexOf(name)+1))
					.sum();		
	}
	
	@Override
	public int getNameScore(Name name, String department) {		
		return map.get(department).execute(name);
	}
	
	protected List<Name> getSortedNamesFromFileStream(Stream<String> fileStream) {
		return fileStream
				.map(line -> line.split(","))
				.flatMap(Arrays::stream)
				.map(firstName -> new Name(firstName.replaceAll("\"", "")))
				.sorted()
				.collect(toList()); 
	}
	
}
