package entities;

import java.util.ArrayList;
import java.util.List;

public class Content {
	private List<String> lines = new ArrayList<>();
	
	public Content() {
	}

	public List<String> getLines() {
		return lines;
	}
	
	public void addLine(String line) {
		lines.add(line);
	}

	@Override
	public String toString() {
		return "Content [lines=" + lines + "]";
	}
}
