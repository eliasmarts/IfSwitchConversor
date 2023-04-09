package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;

import entities.Condition;
import entities.ConditionalStatement;
import entities.Content;
import entities.IfExpression;
import entities.enums.ConditionType;
import services.enums.CommandType;
import services.exceptions.ParseException;

public abstract class IfStatementParser {
	public IfExpression parse(String source) {
		IfExpression expression = new IfExpression();
		StringReader sr = new StringReader(source);
		
		while (!isOver(sr)) {
			CommandType type = nextCommandType(sr);
			
			if (type == CommandType.IF) {
				String content = nextConditionalStatementContent(sr);
				StringReader conditionScan = new StringReader(content);
				
				ConditionalStatement con = new ConditionalStatement();
				

				con.addCondition(nextCondition(conditionScan));

				
				con.setContent(nextContent(sr));
				
				expression.addStatement(con);
				break;
			}
		}
		return expression;
	}
	
	
	private boolean isOver(StringReader sr) {
		
		
		char c;
		try {
			sr.mark(0);
			c = (char) sr.read();
			sr.reset();
		} catch (IOException e) {
			throw new ParseException("help");
		}
		
		
		return c == -1;
	}


	public String toCode(IfExpression source) {
		return null;
	}
	
	protected String readUntil(StringReader sr, char delimiter) {
		String buffer = "";

		int c;
		try {
			c = sr.read();
			
			while (c != delimiter && c != -1) {
				buffer += (char) c;
				
				c = sr.read();
			}

			
			return buffer;
		} catch (IOException e) {
			throw new ParseException("");
		}
		
	}
	
	
	protected ConditionType getConditionType(String type) {
		if (type.equals("=="))
			return ConditionType.EQUALS;
		else if (type.equals("<"))
			return ConditionType.LESS_THAN;
		else if (type.equals(">"))
			return ConditionType.GREATER;
		else if (type.equals(">="))
			return ConditionType.GERATER_OR_EQUALS;
		else if (type.equals("<="))
			return ConditionType.LESS_THAN_OR_EQUALS;
		else if (type.equals("!="))
			return ConditionType.NOT_EQUALS;
		else
			throw new ParseException("Bad condition");
	}
	
	protected abstract CommandType nextCommandType(StringReader sr);
	
	
	protected abstract Condition nextCondition(StringReader sr);
	
	
	protected abstract Content nextContent(StringReader sr);
	
	
	protected abstract String nextConditionalStatementContent(StringReader sr);
}
