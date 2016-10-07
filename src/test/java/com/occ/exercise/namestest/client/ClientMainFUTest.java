package com.occ.exercise.namestest.client;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;

import com.occ.exercise.namestest.service.NamesScoringServiceImpl;

public class ClientMainFUTest {
	
	ClientMain target = new ClientMain();
		
	@Test
	public void getNamesScore() throws IOException, URISyntaxException {
		Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("names.txt").toURI()));
		target.namesScoringService = new NamesScoringServiceImpl();
		assertEquals(871198282, target.getNamesScore(stream));
	}
    
}
