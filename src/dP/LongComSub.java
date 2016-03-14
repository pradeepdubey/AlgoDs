package dP;

public class LongComSub {
	int M=10,N=10;
	int [][]arr = new int[M+1][N+1];
	
	static int longComSub(String s1,String s2) {
		int l1 = s1.length(),l2=s2.length();
		int [][]sol = new int[l1+1][l2+1];
		
		for( int i = 0 ; i <= l1;i++) {
			for (int j=0;j<=l2;j++) {
				if(i==0|| j==0) {
					sol[i][j] = 0;
				} else if (s1.charAt(i-1) == s2.charAt(j-1)) {
				sol[i][j] = sol[i-1][j-1]+1;
				
			} else {
				sol[i][j] = Math.max(sol[i-1][j],sol[i][j-1]);
			}
				
			}
			
		}
		int j=l1,k=l2;
		
		StringBuilder sb = new StringBuilder();
		while (j > 0 && k > 0) {
			if(s1.charAt(j-1) == s2.charAt(k-1)) {
			
				sb.append(s2.charAt(k-1));
				j--;k--;
			} else if(sol[j-1][k] > sol[j][k-1])
				j--;
			else
				k--;
		}
		System.out.println("Pattern is " + sb.reverse().toString());
		return sol[l1][l2];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		
		System.out.println(longComSub(s1,s2));
	}

}

