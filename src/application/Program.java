package application;

import services.IfStatementParser;
import services.JavaIfStatementParser;

public class Program {

	public static void main(String[] args) {
		String input = "if (x == 2) {\n"
				+ "    x = x + 1;\n"
				+ "}\n"
				+ "else if (x == 3) {\n"
				+ "    y = x + 3;\n"
				+ "    z = 34342;\n"
				+ "}\n"
				+ "else {\n"
				+ "    z = 3402304;\n"
				+ "    print(ola);\n"
				+ "}\n";
		
		IfStatementParser parser = new JavaIfStatementParser();
		
		System.out.println(input);
		
		System.out.println(parser.parse(input));
	}

}
