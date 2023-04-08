package application;

import services.IfStatementParser;
import services.JavaIfStatementParser;

public class Program {

	public static void main(String[] args) {
		String input = "";
		
		IfStatementParser parser = new JavaIfStatementParser();
		
		System.out.println(parser.parse(input));
	}

}
