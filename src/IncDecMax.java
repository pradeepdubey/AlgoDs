import java.util.*;


public class IncDecMax {
	public static void main(String args[]) {
		int arr[] = {2,4,6,7,15,17};
		int i = findMax(arr, 0, arr.length -1);
		
		System.out.println("The Max element is "+ i);
	}
	
	public static int findMax(int arr[], int left, int right) {
		 if (left == right)
		     return arr[left];
		if ( right  == left +1) {
			if (arr[left]  >= arr[right])
				return arr[left];
			else
				return arr[right];
		}
		
		int mid = (left +right)/2;
		if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
				return arr[mid];
		}
		if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) {
				return findMax(arr, mid+1, right);
			} else {
				return findMax(arr, left, mid-1);
			}
		
	} 

}
