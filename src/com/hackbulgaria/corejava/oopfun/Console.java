package com.hackbulgaria.corejava.oopfun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
	private BufferedReader reader;

	public String readLine(String prompt) {
		System.out.print(prompt);
		try {
			final String result = bufferedReader().readLine();
			System.out.println(); //add a new line
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void writeLine(String output){
		System.out.println(output);
	}

	private BufferedReader bufferedReader() {
		return reader == null? (reader = new BufferedReader(new InputStreamReader(System.in))) : reader;
	}
}
