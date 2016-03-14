import java.util.*;

public class JudgeScore {
	public void pd(String name) {
		System.out.println(name);
	}

static int maxOnesIndex(int arr[], int n) {
	int max_count=0, max_index=0, prevZero = -1, prevPrevZero = -1;
	
	for ( int i=0;i< n;i++) {
			if (arr[i] == 0) {
				if (i - prevPrevZero > max_count) {
					max_count = i - prevPrevZero;
					max_index = prevZero;
				}
				prevPrevZero = prevZero;
                prevZero = i;
			}
	}
	if (n-prevPrevZero > max_count)
		max_index = prevZero;
	return max_index;
}
static boolean isInteger( String input ) {
    try {
        Integer.parseInt( input );
        return true;
    }
    catch( Exception e ) {
        return false;
    }
}
static String[] JudgeSort(String inp) {
	int len = inp.length();
	String items[] = inp.split(",");
	len = items.length;
	Map<String,Integer> textN = new HashMap<String, Integer>();
	textN.put("one", 1);
	textN.put("two", 2);
	textN.put("three", 3);
	textN.put("four", 4);
	textN.put("five", 5);
	textN.put("six", 6);
	textN.put("seven", 7);
	textN.put("eight", 8);
	textN.put("nine", 9);
	textN.put("ten", 10);
	int j = 11;	
	
	Map<Integer,String> map = new TreeMap<Integer,String>();
	for (int i = 0;i<len;i++){
		if (isInteger(items[i]) == true) {
			int num = Integer.parseInt(items[i]);
			map.put(num,items[i]);
			
		} else {
			if (textN.containsKey(items[i])) {
					
					int num = textN.get(items[i]);
					map.put(num,items[i]);
			} else {
				int flag = 0;
				String []neg = items[i].split(" ");
				if (neg.length == 1) {
					map.put(j,neg[0]);
				} else if ( neg.length == 2){
					int sign = 1;
					if (neg[0].compareTo("positive") == 0) {
						sign = 1;
					} else if (neg[0].compareTo("negative") == 0) {
						sign = -1;
					} else {
						flag = 1;
					}
					if (textN.containsKey(neg[1])) {
						
						int num = textN.get(neg[1]);
						map.put(sign*num,items[i]);
					} else {
						flag = 1;
					}
				} else {
					flag = 1;
				}
				if (flag == 1) {
					map.put(j,"Invalid:" + items[i]);
					flag=0;
				}
				j++;
				
				
			}
		}
		
		
	}
	String[] result = map.values().toArray(new String[len]);
	return result;
}
 public static void main(String arg[]) {
	 String inp = "4,12,-5,3,8,2,negative seven,positive ten,negative ten ten,neg nine";
	 System.out.println(inp);
	 
	 String sol[] = JudgeSort(inp);
	
	 for(String str : sol)
	        System.out.println(str);
	 
}
}
