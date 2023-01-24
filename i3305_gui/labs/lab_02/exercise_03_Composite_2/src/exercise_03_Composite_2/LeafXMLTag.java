package exercise_03_Composite_2;

public class LeafXMLTag extends XMLTag {
	String content;
	
	public String toString() {
		return "<" + tagName + ">" + content + "</" + tagName + ">\n";
	}
	
	public LeafXMLTag(String tagName, String content) {
		super(tagName);
		this.content = content;
	}
}
