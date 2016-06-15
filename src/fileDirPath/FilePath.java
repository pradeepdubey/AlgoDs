package fileDirPath;

import java.util.ArrayList;
import java.util.Stack;

public class FilePath {
	public String path(ArrayList<String> inp) {
		StringBuilder sb = new StringBuilder();
		int len = inp.size();
		int first = 0;
		int i = 0;
		Stack<String> st = new Stack<>();
		while(i < len ) {
			String curr = inp.get(i);
			String[] sp = curr.split("/");
			
			int size = sp.length;
			int j = 0;
			while(j<size) {
				//System.out.println("Cuurent is " + sp[j]);
				/*if(sp[j].contains("")) {
					j++;
					continue;
				}*/
					
				if(sp[j].contentEquals("..") ) {
					if(first == 0) {
						System.out.println("First Element  cannont be ../zero");
						return sb.toString();
					}
					st.pop();
				} else {
					first=1;
					st.push(sp[j]);
				}
				j++;
			}
			i++;
		}
		int size = st.size();
		i=0;
		while(i<size) {
			sb.append("/");
			sb.append(st.get(i));
			i++;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> inp = new ArrayList<>();
		inp.add("foo");
		inp.add("/bar");
		inp.add("..");
		inp.add("test/thing");
		inp.add("../bob");
		
		FilePath fp  = new FilePath();
		String sol = fp.path(inp);
		System.out.println(sol);
	}

}
