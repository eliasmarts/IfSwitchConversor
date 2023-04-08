package services;

import java.util.Scanner;

import entities.Condition;
import entities.Content;
import entities.IfExpression;
import services.enums.CommandType;

public abstract class IfStatementParser {
	public IfExpression parse(String source) {
		IfExpression expression = new IfExpression();
		Scanner sc = new Scanner(source);
		sc.close();
		
		return expression;
	}
	
	
	public String toCode(IfExpression source) {
		return null;
	}
	
	
	protected abstract CommandType nextCommandType(Scanner sc);
	
	
	protected abstract Condition nextCondition(Scanner sc);
	
	
	protected abstract Content nextContent(Scanner sc);
	
	
	protected abstract String nextConditionalStatementContent(Scanner sc);
}
