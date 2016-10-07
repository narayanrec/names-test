package com.occ.exercise.namestest.strategy;

import com.occ.exercise.namestest.domain.Name;

public interface NameScoringStrategy {
	int execute(Name name);
}
