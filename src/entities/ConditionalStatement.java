package entities;

import java.util.ArrayList;
import java.util.List;

public class ConditionalStatement {
	private List<Condition> conditions = new ArrayList<>();
	private Content content;
	public ConditionalStatement(List<Condition> conditions, Content content) {
		this.conditions = conditions;
		this.content = content;
	}
	public ConditionalStatement() {
	}
	public List<Condition> getConditions() {
		return conditions;
	}
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public void addCondition(Condition condition) {
		conditions.add(condition);
	}
	@Override
	public String toString() {
		return "ConditionalStatement [conditions=" + conditions + ", content=" + content + "]";
	}
	
}
