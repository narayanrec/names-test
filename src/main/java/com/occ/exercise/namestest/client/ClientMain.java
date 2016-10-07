package com.occ.exercise.namestest.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.occ.exercise.namestest.service.NamesScoringService;
import com.occ.exercise.namestest.service.NamesScoringServiceImpl;

public class ClientMain {
	NamesScoringService namesScoringService;
	
    public static void main( String[] args ) throws IOException {    	
    	ClientMain clientMain = new ClientMain();
    	clientMain.namesScoringService = new NamesScoringServiceImpl();
    	System.out.println("Total score for Names is " + clientMain.getNamesScore(Files.lines(Paths.get(args[0]))));    	        
    }
    
    public int getNamesScore(Stream<String> stream) {        
		return namesScoringService.getNamesScore(stream, "department1");			
    }
    

}
