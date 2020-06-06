package com.prac.core.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SearchInFile {

	static final String fileName = "C://Krsna//Study//CoreJava//Materials//Annotations.txt";
	
	public static void main(String[] args) throws IOException {
    
		readUsingFiles();
	}
	
	private static void readUsingFiles() throws IOException {
        Path path = Paths.get(fileName);
        //read file to byte array
        byte[] bytes = Files.readAllBytes(path);
        System.out.println("Read text file using Files class");
        //read file to String list
        @SuppressWarnings("unused")
		List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println(new String(bytes));
    }
	
}
