package com.dumbu.ai.ai;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

	public static void main(String[] args) {
		try {
			List<String> allLines = Files
					.readAllLines(Paths.get("D:\\projects\\ai\\src\\main\\resources\\messagdata.txt"));
			/*
			 * for (String line : allLines) { if(line.startsWith("Q")) {
			 * System.out.println(line); } }
			 */
			
			for (int i = 0; i <= allLines.size(); i++) {
				System.out.println(allLines.get(i));
				System.out.println(allLines.get(i+1));
				i=i+2;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
