package OJCP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Array2List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> initialList =  Arrays.asList("ebay", "google", "ibm","microsoft", "google",
											"ebay","ibm");
		System.out.println(initialList);
		Set<String> hashSetList = new  HashSet<String>(initialList);
		System.out.println(hashSetList);
		
		Set<String> treeSetList = new TreeSet<String>(initialList) ;
		System.out.println(treeSetList);
		ArrayList<String> company = new ArrayList<String>();
		company.add("eBay");
		company.add("Paypal");
		company.add("Google");
	

		for(String s: company)
			System.out.println(s);
			
		
	}

}
