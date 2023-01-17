package hierarchy_management;

import java.util.ArrayList;

public class Manager extends Teacher {
	private ArrayList<Teacher> boardMembers;
	
	public void addTeacher(Teacher teacher) {
		boardMembers.add(teacher);
	}
	
	public void removeTeacher(Teacher teacher) {
		boardMembers.remove(teacher);
	}
	
	public void removeTeacher(String name) {
		for (int i = 0; i < boardMembers.size(); i++) {
			if (boardMembers.get(i).getName().equals(name)) {
				removeTeacher(boardMembers.get(i));
				break;
			}
		}
	}

	
	@Override
	public String toString() {
		String result = this.name + " is a Manager\n";

		for (int i = 0; i < boardMembers.size(); i++) {
			result += "\t" + boardMembers.get(i);
		}
		
		return result;
	}
	
	
}
