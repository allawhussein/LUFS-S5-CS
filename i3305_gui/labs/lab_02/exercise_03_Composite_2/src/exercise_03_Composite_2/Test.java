package exercise_03_Composite_2;

public class Test {
	public static void main(String args[]) {
		NestedXMLTag test = new NestedXMLTag("class");
		NestedXMLTag std = new NestedXMLTag("student");
		std.addTag(new LeafXMLTag("firstname", "Ahmad"));
		std.addTag(new LeafXMLTag("lastname", "Youssef"));
		std.addTag(new LeafXMLTag("ID", "LB1234"));
		std.addTag(new LeafXMLTag("mark", "85"));
		test.addTag(std);
		
		std = new NestedXMLTag("student");
		std.addTag(new LeafXMLTag("firstname", "Mark"));
		std.addTag(new LeafXMLTag("lastname", "Ghostina"));
		std.addTag(new LeafXMLTag("ID", "LB1235"));
		std.addTag(new LeafXMLTag("mark", "95"));
		test.addTag(std);
		
		System.out.println(test.toString());
	}
}
