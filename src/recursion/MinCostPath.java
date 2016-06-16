package recursion;

public class MinCostPath {
	public static int R=4;
	public static int C=4;

	public MinCostPath() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cost[][] = {{13, 22, 23, 14},
						{14, 101, 12, 12},
						{21, 15, 13, 14},
						{12, 15, 23, 24}};
		printMat(cost,R,C);
		System.out.println("Minimum cost is " + minCost(cost, 4, 4));
		return;

	}

	private static int minCost(int[][] cost, int r, int c)
	{
		// TODO Auto-generated method stub
	     int i=0, j=0;
		 
		 int[][]costMat = new int[R][C];  
		 
		  costMat[0][0] = cost[0][0];
		 
		     
		   for (i = 1; i < r; i++)
		        costMat[i][0] = costMat[i-1][0] + cost[i][0];
		 
		   for (j = 1; j < c; j++)
		        costMat[0][j] = costMat[0][j-1] + cost[0][j];
		 
		     /* Construct rest of the Cost Matrix array */
		     for (i = 1; i < r; i++)
		        for (j = 1; j < c; j++)
		        	// We can come from left, top and diagonal matrix element
		            costMat[i][j] = min(costMat[i-1][j-1], costMat[i-1][j], costMat[i][j-1]) + cost[i][j];
		     		// We cn only come from top or left
		     		//costMat[i][j] = min(99999999, costMat[i-1][j], costMat[i][j-1]) + cost[i][j];
		 
		     printMat(costMat,r,c);
		     return costMat[r-1][c-1];
		}

	private static void printMat(int[][] mat,int r,int c) {
		// TODO Auto-generated method stub
		System.out.println("Pritning matrix");
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				System.out.print(mat[i][j] + "  ");
			}
			System.out.println("");
		}// TODO
		
	}

	private static int min(int x, int y, int z) {
		// TODO Auto-generated method stub
		if (x < y)
		      return (x < z)? x : z;
		   else
		      return (y < z)? y : z;
		
	}
		
	}


