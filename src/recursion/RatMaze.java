package recursion;

public class RatMaze {

	static int M=8, N=8;
	static int noOfDir = 4;
	static int count=0;

	
	//static int dirX[]={-1,1,-1,-1,0,0,1,1};
	//static int dirY[]={0,-1,1,-1,1,-1,0,1};
	
	static int dirX[]={-1,0,0,1};
	static int dirY[]={0,1,-1,0};
	
	private static void printMat( int[][] mat, int k, int l) {
		System.out.println("Pritning Vsited matrix for " + k + "  " + l);
		for (int i=0;i<M;i++) {
			for (int j=0;j<N;j++) {
				System.out.print(mat[i][j] + "  ");
			}
			System.out.println("");
		}// TODO
	}
	private static boolean findpath(int[][] mat, int x, int y, int[][] visited,int arr[])
	{	
		if(x == M -1 && y == N - 1 ) {
			visited[x][y] = 1;
			printMat(visited,M,N);
			return true;
		}	
		if(visited[x][y] == 0)
		{
			visited[x][y] =1;
			for(int k=0;k<noOfDir;k++)
			{
				int ii = x + dirX[k];
				int jj = y + dirY[k];
				if(isSafe(mat,ii,jj) == true)
				{
					printMat(visited,M,N);
					if(findpath(mat,ii,jj,visited,arr) == true)
						return true;				
				} else
					continue;
			}
			visited[x][y]=0;
		}
	return false;
	}
	
	private static boolean isSafe(int[][] visited, int x, int y) {
		// TODO Auto-generated method stub
		 if(x >= 0 && x < M && y >= 0 && y < N && visited[x][y] == 1)
		        return true;
		return false;
	}
	private static boolean path(int[][] mat) {
		// TODO Auto-generated method stub
		int visited[][] = new int[M][N];
		for (int i=0;i<M;i++) {
			for (int j=0;j<N;j++) {
				visited[i][j] = 0;
			}
		}
		int path[] = new int[M*N];
		 boolean res = findpath(mat,0,0,visited,path);
					return res;		
	


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][]={{1,0,1,0,0,1,1,1},
					{1,0,1,0,0,1,1,1},
				   	{1,0,1,1,0,1,1,1},
				    {1,1,0,0,0,1,1,1},
				    {0,1,1,0,0,0,1,1},
					{1,0,1,1,1,1,0,1},
					{1,0,0,0,0,1,1,1},
					{1,0,1,0,0,1,1,1}};
		boolean reslen = path(mat);


	}

}
