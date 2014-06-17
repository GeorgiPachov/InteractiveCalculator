package com.hackbulgaria.corejava.oopfun;

public class Calculator {
	private static final String allowedCharacters = getAllowedCharacters();

	public double calculate(String expression) {
		// fix mashed user input
		final StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			if (allowedCharacters.contains("" + expression.charAt(i))) {
				stringBuilder.append(expression.charAt(i));
			}
		}

		expression = stringBuilder.toString();

		// fix whitespace issues
		while (expression.contains(" ")) {
			expression = expression.replace(" ", "");
		}

		// calculate stuff in brackets
		while (expression.contains(")")) {
			final int firstClosingBracket = expression.indexOf(')');
			final int itsOpeningBracket = expression.length() - 1
					- new StringBuilder(expression).reverse().indexOf("(", expression.length() - firstClosingBracket);
			String bracketExpression = expression.substring(itsOpeningBracket + 1, firstClosingBracket);
			expression = expression
					.replace('(' + bracketExpression + ')', String.valueOf(calculate(bracketExpression)));
		}

		if (expression.contains("+")) {
			String[] nodes = expression.split("\\+");

			double sum = 0;
			for (int i = 0; i < nodes.length; i++) {
				sum += (calculate(nodes[i]));
			}
			return sum;
		}

		if (expression.contains("-")) {
			String[] nodes = expression.split("\\-");
			//we have a real - operation
			if (nodes[0].length() > 0 && isDigit(nodes[0])) {
				double sum = calculate(nodes[0]);
				for (int i = 1; i < nodes.length; i++) {
					sum -= (calculate(nodes[i]));
				}
				return sum;
			}
		}

		if (expression.contains("*")) {
			String[] nodes = expression.split("\\*");
			double product = 1;
			for (int i = 0; i < nodes.length; i++) {
				product *= calculate(nodes[i]);
			}
			return product;
		}

		if (expression.contains("/")) {
			final int indexOfSplit = expression.indexOf('/');
			double leftSide = calculate(expression.substring(0, indexOfSplit));
			double rightSide = calculate(expression.substring(indexOfSplit + 1));
			return leftSide / rightSide;
		}

		if (expression.contains("^")) {
			final int indexOfSplit = expression.indexOf('^');
			double leftSide = calculate(expression.substring(0, indexOfSplit));
			double rightSide = calculate(expression.substring(indexOfSplit + 1));
			return Math.pow(leftSide, rightSide);
		}

		if (expression.contains("!")) {
			Double number = Double.parseDouble(expression.replace("!", ""));
			long res = 1;
			while (number - 0.0001f > 1) {
				res *= number--;
			}
			return res;
		}

		//we have just a unary minus!
		//no need to check, the minus cannot be other than unary!
		if (expression.contains("-")){
			return - calculate(expression.substring(1));
		}

		return Double.parseDouble(expression);
	}

	private boolean isDigit(String nodes) {
		for (int i = 0; i < nodes.length(); i++){
			if (!Character.isDigit(nodes.charAt(i))){
				return false;
			}
		}
		return true;
	}

	private static String getAllowedCharacters() {
		return "!^0123456789.+/*-()";
	}
}
