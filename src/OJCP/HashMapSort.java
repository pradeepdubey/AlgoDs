package OJCP;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HashMapSort {
	public static void printMap (Map<Integer,String> map) {
		 Set<Entry<Integer, String>> set1 = map.entrySet();
	        Iterator<Entry<Integer, String>> it1 = set1.iterator();
	        while(it1.hasNext()) {
	        	Map.Entry<Integer,String> me = it1.next();
	        	System.out.print(me.getKey() + ":" + me.getValue() +", " );
	        }
	        System.out.println("");
	}
	 private static HashMap sortByValues(HashMap map) { 
	       List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });

	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	  }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> hmap = new HashMap<Integer,String>();
		hmap.put(5, "Abc");
        hmap.put(11, "Cde");
        hmap.put(4, "Zef");
        hmap.put(77, "Yve");
        hmap.put(9, "Pfrt");
        hmap.put(66, "Qwsd");
        hmap.put(0, "Rdef");
        
        printMap(hmap);
        Map<Integer,String> map = new TreeMap<Integer,String>(hmap);
        printMap(map);
        
        
        

	}

}
