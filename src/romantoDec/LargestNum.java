package romantoDec;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {50,345,9,234,1001};
		String str = largest(arr);
		System.out.println(str);

	}

	private static String largest(int[] arr) {
		// TODO Auto-generated method stub
		String[] str = new String[arr.length];
		for(int i =0;i<arr.length;i++) {
			str[i]=String.valueOf(arr[i]);
		}
		Arrays.sort(str, new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				String s1=arg0+arg1;
				String s2= arg1+arg0;
				return -s1.compareTo(s2);
				
			}
			
		});
		StringBuilder sb = new StringBuilder();
		for(String s:str){
			sb.append(s);
		}
		return sb.toString();
	}

}
