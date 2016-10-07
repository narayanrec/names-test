package com.occ.exercise.namestest.service;

import java.util.List;
import java.util.stream.Stream;

import com.occ.exercise.namestest.domain.Name;

public interface NamesScoringService {
	
	int getNamesScore(Stream<String> fileStream, String department);
	
	int getNamesScore(List<Name> names, String department);
	
	int getNameScore(Name name, String department);

}
