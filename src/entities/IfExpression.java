package entities;

import java.util.ArrayList;
import java.util.List;

public class IfExpression {
	private String variableName;
	private List<ConditionalStatement> statements = new ArrayList<>();
	private Content elseStatement;
	public IfExpression() {
	}
	
	public IfExpression(String variableName) {
		this.variableName = variableName;
	}
	public String getVariableName() {
		return variableName;
	}
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	public Content getElseStatement() {
		return elseStatement;
	}
	public void setElseStatement(Content elseStatement) {
		this.elseStatement = elseStatement;
	}
	public List<ConditionalStatement> getStatements() {
		return statements;
	}
	
	public void addStatement(ConditionalStatement statement) {
		statements.add(statement);
	}

	@Override
	public String toString() {
		return "IfExpression [variableName=" + variableName + ", statements=" + statements + ", elseStatement="
				+ elseStatement + "]";
	}
	
	
}
