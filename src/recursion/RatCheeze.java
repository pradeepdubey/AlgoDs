package recursion;

public class RatCheeze {
	public static int M = 4;
	public static int N = 4;
	public static int dirX[] = {0,1,-1,0};
	public static int dirY[] = {1,0,0,-1};
	
	public RatCheeze() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][] = {{1,1,1,0},
						{1,0,1,0},
						{1,1,1,1},
						{1,0,1,1}};
		
		findPath(maze,M,N);
		
		
	}

	private static void findPath(int[][] maze, int m2, int n2) {
		// TODO Auto-generated method stub
		int[][] visited = new int[M][N];
		find(maze,visited,0,2);
		
	}

	private static boolean find(int[][] maze, int[][] visited, int i, int j)
	{
		// TODO Auto-generated method stub
		if(i==M-1 && j ==N-1)
		{
			visited[i][j] = 1;
			System.out.println("Found the Cheeze at the end");
			printMat(visited);
			return true;
		}
		
		if(isSafe(i,j) == true && maze[i][j] == 1)
		{
			visited[i][j]=1;
			printMat(visited);
			for (int k=0;k<4;k++)
			{
				int ii= i + dirX[k];
				int jj= j + dirY[k];
				if( isSafe(ii,jj) == true)
				{
					if(find(maze,visited,ii,jj) == true)
						return true;
				} else
					continue;
			}
			visited[i][j]=0;
			return false;
			
			
			
		}
		return false;
		
	}

	private static boolean isSafe(int i, int j)
	{
		// TODO Auto-generated method stub
		if( i < M && i >=0 && j < N && j >=0)
			return true;
		return false;
	}

	private static void printMat(int[][] visited)
	{
		// TODO Auto-generated method stub
		System.out.println("Printing the Matrix Path");
		for (int i=0;i<M;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(" " + visited[i][j]);
			}
			System.out.println("");
		}
		
	}
	
	

}
