package exercise_03_Composite_2;

import java.util.LinkedList;
import java.util.List;

public class NestedXMLTag extends XMLTag {
	List<XMLTag> innerTags = new LinkedList<XMLTag>();
	
	public void addTag(XMLTag innerTag) {
		innerTags.add(innerTag);
	}
	
	public void removeTag(XMLTag innerTag) {
		innerTags.remove(innerTag);
	}
	
	public NestedXMLTag(String tagName) {
		super(tagName);
	}

	public String toString() {
		String result = "<" + tagName + ">\n" ;
		
		for (XMLTag inner : innerTags) {
			result += inner.toString();
		}
		
		result = result.replaceAll("\n", "\n\t");
		result = result.substring(0, result.length() - 2);  
		result += "\n</" + tagName + ">\n";
		return result;
	}
}
