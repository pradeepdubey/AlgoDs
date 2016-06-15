package incDec;

public class IncDec {
	static int res=-1;
	public static int incDecP(int[] arr,int l,int r) {
		
		if(l==r)
			return l;
		
		if ((r == l + 1) && arr[l] >= arr[r])
		      return l;
	    if ((r == l + 1) && arr[l] < arr[r])
		      return r;
		int mid = (l+r)/2;
		if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1])
			return mid;
		
		if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
				return incDecP(arr,l,mid-1);
			else
				return incDecP(arr,mid+1,r);
				
		}
	
	public static void main(String args[]) {
		int ar[] = {3,2,1};
		int res = incDecP(ar,0,ar.length-1);
		System.out.println("Pivot is" + res);
	}

}
