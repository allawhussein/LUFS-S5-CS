package exercise_03_Composite_2;

public abstract class XMLTag {
	String tagName;

	public String getTag_name() {
		return tagName;
	}

	public void setTag_name(String tag_name) {
		this.tagName = tag_name;
	}
	
	public XMLTag(String tagName) {
		this.tagName = tagName;
	}
	
	@Override
	public abstract String toString();
}
