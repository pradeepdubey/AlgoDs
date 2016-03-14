package dP;

public class LongIncSub {
	
	public static int lis(int[] arr) {
		int max=0;
		int len = arr.length;
		int[] sol = new int[len];
		
		for (int i=0;i<len;i++) {
			sol[i]=1;
		}
		
		for (int i=1;i<len;i++) {
			for (int j=0;j<i;j++) {
				if (arr[i] > arr[j] && sol[i] < sol[j] +1) {
					sol[i]=sol[j]+1;
				}
			}
		}
		
		for (int i=0;i<len;i++) {
			if(max < sol[i])
				max=sol[i];
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr = {1,4,30,16,8,19,20,40};
		System.out.println("Length of Longest Subsequence Sum is" + lis(arr));

	}

}
