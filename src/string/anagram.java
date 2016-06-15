package string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
public class anagram {

	private static HashMap<String, ArrayList<String>> anagramMap = new HashMap<String, ArrayList<String>>();
	
	public static void findAnagrams(String [] dictionary) {
	
		int len = dictionary.length;
	    for (int i=0; i<len; i++) {
	    	String sortedWord = sortWord(dictionary[i]);
	    	ArrayList<String> wordList = anagramMap.get(sortedWord);
	    	if (wordList == null) {
	    		wordList = new ArrayList<String>();   
	    	}
	    	wordList.add(dictionary[i]);
	    	anagramMap.put(sortedWord, wordList);
	 }
	}
	 
	private static String sortWord(String original) {
		// TODO Auto-generated method stub
		
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
	  	
	}

	public static ArrayList<String> getAnagrams(String word) {
	 if (word == null) { return null; }
	  
	 String sortedWord = sortWord(word);
	 
	 return anagramMap.get(sortedWord);
	}
	 
	public static void printAnagrams(String word) {
		
		if (word == null) {
			System.out.println("Input word is null!");
		} else {
			ArrayList<String> wordList = getAnagrams(word);
			if (wordList == null) {
				System.out.println("No anagrams exists for : " + word);
			} else {
				int i =0;
				while (i<wordList.size()) {
					System.out.print(wordList.get(i++) + ",");
				}
				System.out.println("!");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] inp= {"dog","cat","god","tac","time"};
	      
	       System.out.println(inp);
	      
	       findAnagrams(inp);
	        for (int i=0;i<inp.length;i++) {
	        	printAnagrams(inp[i]);
	        }
	        System.out.println(anagramMap);
	        Map<String,ArrayList<String>> map = new TreeMap<String,ArrayList<String>>(anagramMap);
	        System.out.println(map);
	        Set<Entry<String, ArrayList<String>>> set2 = map.entrySet();
	         Iterator<Entry<String, ArrayList<String>>> iterator2 = set2.iterator();
	         while(iterator2.hasNext()) {
	              Map.Entry<String, ArrayList<String>> me2 = (Map.Entry<String, ArrayList<String>>)iterator2.next();
	              System.out.print(me2.getKey() + ": ");
	              System.out.println(me2.getValue());
	         }

	}

}
