package com.prac.core.jdk5.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TextProcessing {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String args[]) {
		HashMap<Integer, String> filteredMap = new HashMap<>();
		HashMap<String, String> map = new HashMap<>();
		
		// Fetch the Data
		map = getData();

		// Filter the Map
		filteredMap = getDistinctKey(map);
		
		// Process the Value
		LinkedHashMap result = process(map, filteredMap);
		 System.out.println("Final Map Values: "+result);
	}

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	private static HashMap<Integer, String> getDistinctKey(HashMap<String, String> map) {
		  System.out.println("Entire Map: "+map);
		  System.out.println();
		  
		  ArrayList<String> keyList = new ArrayList<>(map.keySet());
		  System.out.println("All Keys: "+keyList);
		  ArrayList<String> ValueList = new ArrayList<>(map.values());
		  System.out.println("All Values: "+ValueList);
		  
//		  keyList.forEach(x->System.out.print(x+", "));
		  System.out.println();
		  
		  Set<Integer> iKey = new HashSet<Integer>(); 
		  for (Map.Entry<String, String> entry : map.entrySet()) {
			iKey.add(splitKey(entry.getKey()));  
		  }
		  
		  System.out.println("Distinct Keys: "+iKey); 
		  
		  HashMap<Integer, String> hMap = new HashMap<>();
		  
		  for (Integer integer : iKey) {
			  String match = integer +"(.*)";
			  ArrayList<String> aList = new ArrayList<>();
			  
			  for (String kStr : keyList) {
				  if(kStr.matches(match)) {
					  aList.add(kStr);
				  }
			  }
			  
			  Collections.sort(aList);
			  hMap.put(integer, aList.get(0));
		  }
		  
		  System.out.println("WhichOne_To_Pick: "+hMap);
		  System.out.println();
		  
		  return hMap;
		  
		/*
		 * Collection<String> iKey = map.entrySet() .stream() .map(Entry::getKey)
		 * .collect(Collectors.toCollection(HashSet::new));
		 */
	}

	private static Integer splitKey(String key) {
		String str = key.substring(0, (key.length() - 1));
		return Integer.parseInt(str);
	}

	@SuppressWarnings("rawtypes")
	private static HashMap getData() {

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("50A", "50A Text1, Value");
		map.put("51A", "51A Text2, Value");
		//map.put("52A", "52A Text3, Value");
		map.put("53A", "53A Text4, Value");
		map.put("54A", "54A Text5, Value");
		//map.put("55A", "55A Text6, Value");
		map.put("56A", "56A Text7, Value");
		map.put("57A", "57A Text8, Value");
		map.put("58A", "58A Text9, Value");
		map.put("59A", "59A Text10, Value");
		//map.put("60A", "60A Text11, Value");
		map.put("61A", "61A Text12, Value");
		map.put("62A", "62A Text13, Value");
		//map.put("63A", "63A Text14, Value");
		map.put("50B", "50B Text15, Value");
		map.put("51B", "51B Text16, Value");
		map.put("52B", "52B Text17, Value");
		map.put("53B", "53B Text18, Value");
		map.put("54B", "54B Text19, Value");
		map.put("55B", "55B Text20, Value");
		map.put("56B", "56B Text21, Value");
		map.put("57B", "57B Text22, Value");
		map.put("58B", "58B Text23, Value");
		map.put("59B", "59B Text24, Value");
		//map.put("60B", "60B Text25, Value");
		map.put("61B", "61B Text26, Value");
		map.put("62B", "62B Text27, Value");
		//map.put("63B", "63B Text28, Value");
		map.put("50C", "50C Text29, Value");
		map.put("51C", "51C Text30, Value");
		map.put("52C", "52C Text31, Value");
		map.put("53C", "53C Text32, Value");
		map.put("54C", "54C Text33, Value");
		map.put("55C", "55C Text34, Value");
		map.put("56C", "56C Text35, Value");
		map.put("57C", "57C Text36, Value");
		map.put("58C", "58C Text37, Value");
		map.put("59C", "59C Text38, Value");
		map.put("60C", "60C Text39, Value");
		map.put("61C", "61C Text40, Value");
		map.put("62C", "62C Text41, Value");
		map.put("63C", "63C Text42, Value");

		return map;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static LinkedHashMap process(HashMap map, HashMap<Integer, String> filteredMap) {
		LinkedHashMap<String, String> processedMap = new LinkedHashMap<String, String>();
		ArrayList<String> valueList = new ArrayList<>(filteredMap.values());
		for (String str : valueList) {
			//Map.Entry<String, String> pair = (Entry<String, String>) map.get(str);
			String KeyValue = (String) map.get(str);
			processedMap = getValue(KeyValue, str, processedMap);
		}
		return processedMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static LinkedHashMap getValue(String pair, String key, LinkedHashMap processedMap) {
		processedMap.put(key, pair != null ? pair.split(",")[0] : null);
		return processedMap;
	}
	
}// TextProcessing