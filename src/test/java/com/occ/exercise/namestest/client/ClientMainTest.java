package com.occ.exercise.namestest.client;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

import com.occ.exercise.namestest.service.NamesScoringService;

public class ClientMainTest {
	
	ClientMain target = new ClientMain();
		
	@Test
	public void getNamesScore() throws IOException {
		NamesScoringService namesScoringServiceMock = mock(NamesScoringService.class);
		target.namesScoringService = namesScoringServiceMock;
		Stream<String> stream = Arrays.asList("abc").stream();
		
		when(namesScoringServiceMock.getNamesScore(stream, "department1")).thenReturn(1111);
		target.getNamesScore(stream);
		verify(namesScoringServiceMock);
	}
    
}
