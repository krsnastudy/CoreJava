package com.prac.core.jdk5.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {

		/* Way 1 */
		String inputStr = "teeter";

		for (char i : inputStr.toCharArray()) {
			if (inputStr.indexOf(i) == inputStr.lastIndexOf(i)) {
				System.out.println("First non-repeating character is: " + i);
				break;
			}
		}

		/* Way 2 */
		String str = "abaccd";
		char[] cArray = str.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < cArray.length; i++) {
			char c = cArray[i];
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
//				System.out.println(entry.getKey());
				System.out.println("Java6 Non-Repeating Character: " + entry.getKey());
				break;
			}
		}

		/* Way 3 */
		Map<Character, Integer> lMap = new LinkedHashMap<>();
		for (Character ch : str.toCharArray()) {
			lMap.put(ch, lMap.containsKey(ch) ? map.get(ch) + 1 : 1);
		}
		Character c = lMap.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
		System.out.println("Java8 Non-Repeating Character: " + c);

		/* Way 4 */
		String str1 = "Karnataka Chief Minister Basavaraj Bommai has strongly condemned a resolution moved in the assembly x of neighbouring Maharashtra resolving to protect the states interests amid a border row between the two states where the BJP is in power z";
		str1 = str1.replace(" ", "").toLowerCase();

		Map<Character, Integer> linkedHashMap = new LinkedHashMap<>();
		for(Character c1 : str1.toCharArray()) {
			linkedHashMap.merge(c1, 1, Integer::sum);
		}

//		System.out.println(linkedHashMap);
		Character character = linkedHashMap.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
		System.out.println("Java8 Non-Repeating Character: " + character);
	}
}

// https://javahungry.blogspot.com/2013/12/first-non-repeated-character-in-string-java-program-code-example.html
