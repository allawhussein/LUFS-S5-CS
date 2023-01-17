package exercise_01_flyweight;

import java.util.HashMap;


public class Dictionary {
	
	private static final HashMap<Character, DisplayCharacter> dictionary = 
			new HashMap<Character, DisplayCharacter>();
	
	public static DisplayCharacter getCharacter(char letter) {
		DisplayCharacter result = (DisplayCharacter)dictionary.get(letter);
		
		if (result == null) {
			result = new DisplayCharacter(letter);
			dictionary.put(letter, result);
			System.out.println("Character '" + letter + "' is added to the dictionary");
		}
		
		result.setUpperCase(Character.isUpperCase(letter));
		return result;
	}
}
