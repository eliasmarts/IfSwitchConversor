package entities;

import entities.enums.ConditionType;

public class Condition {
	private String variableName;
	private String value;
	private ConditionType type;
	
	public Condition() {
	}

	public Condition(String variableName, String value, ConditionType type) {
		super();
		this.variableName = variableName;
		this.value = value;
		this.type = type;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ConditionType getType() {
		return type;
	}

	public void setType(ConditionType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Condition [variableName=" + variableName + ", value=" + value + ", type=" + type + "]";
	}
	
	
}
