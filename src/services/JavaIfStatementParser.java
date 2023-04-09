package services;


import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import entities.Condition;
import entities.Content;
import entities.enums.ConditionType;
import services.enums.CommandType;
import services.exceptions.ParseException;

public class JavaIfStatementParser extends IfStatementParser {

	@Override
	protected CommandType nextCommandType(StringReader sr) {
		String command = readUntil(sr, ' ');
		
		if (command.equals("if")) {
			return CommandType.IF;
		}
		if (command.equals("else")) {
			String buffer = "";
			try {
			while (true) {
				char c;
				
				c = (char) sr.read();
				if (c == '{')
					return CommandType.ELSE;
				buffer += c;
				if (buffer.endsWith("if"))
					return CommandType.IF;
				
				
				
			}
			} catch (IOException e) {
				throw new ParseException("Not possible to interpret command");
			}
		}
		return null;
		
	}

	@Override
	protected Condition nextCondition(StringReader sr) {
		String variableName = readUntil(sr, ' ').replace('(', ' ');
		String type = readUntil(sr, ' ');
		String value  = readUntil(sr, ' ');
		
		ConditionType cType = getConditionType(type);
		
		return new Condition(variableName, value, cType);
	}

	@Override
	protected Content nextContent(StringReader sr) {
		String buffer = "";
		Content content = new Content();
		try {
			int c = sr.read();
			while (c != '}') {
				if (c == '\n') {
					content.addLine(buffer);
					buffer = "";
				}
				else {
					buffer += (char) c;
					if (c == -1)
						throw new ParseException("Unbalanced brackets");
				}
				
				c = sr.read();
			}
			
			return content;
		} catch (IOException e) {
			throw new ParseException("");
		}
	}

	@Override
	protected String nextConditionalStatementContent(StringReader sr) {
		try {
			return readUntil(sr, '{').trim();
		}
		catch (ParseException e) {
			throw new ParseException("If not closed");
		}
	}

}
