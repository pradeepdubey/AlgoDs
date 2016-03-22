package string;

import java.util.ArrayList;

public class Permutation {
	ArrayList<String> sol = new ArrayList<String>();
	void permute(String prefix,String str2) {
		int n = str2.length();
		
		if(n == 0) {
			sol.add(prefix);
			System.out.println(prefix);
		}
		else {
			for(int i=0;i<n;i++) {
				permute(prefix+ str2.charAt(i), str2.substring(0, i) + str2.substring(i+1, n));
			}
		}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation str = new Permutation();
		str.permute("","a");
		System.out.println(str.sol + " " + str.sol.size());
		

	}

}
