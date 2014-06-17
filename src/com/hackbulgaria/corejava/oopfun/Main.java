package com.hackbulgaria.corejava.oopfun;

public class Main {
	public static void main(String[] args) {
		final Console console = new com.hackbulgaria.corejava.oopfun.Console();
		final String prompt = "Enter expression:> ";
		final Calculator calculator = new Calculator();
		String input = null;
		while (true) {
			input = console.readLine(prompt);
			if ("exit".equals(input)) {
				console.writeLine("Bye!");
				break;
			}
			final double result = calculator.calculate(input);
			console.writeLine("Output:> " + result);
		}
	}
}
