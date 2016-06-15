package recursion;

public class PrintPaths {


	static int M=8, N=8;
	static int noOfDir = 4;
	static int count=0;

	
	//static int dirX[]={-1,1,-1,-1,0,0,1,1};
	//static int dirY[]={0,-1,1,-1,1,-1,0,1};
	
	static int dirX[]={-1,0,0,1};
	static int dirY[]={0,1,-1,0};
	//static int dirX[]={0,1};
	//static int dirY[]={1,0};
	private static void printMat( int[][] mat, int k, int l) {
		System.out.println("Pritning Vsited matrix for " + k + "  " + l);
		for (int i=0;i<M;i++) {
			for (int j=0;j<N;j++) {
				System.out.print(mat[i][j] + "  ");
			}
			System.out.println("");
		}// TODO
	}
	private static void findpath(int[][] mat, int x, int y, int m, int n,int[][] visited,int len)
	{	
		if(x == m-1 && y == n-1 )
		{
			visited[x][y] = 1;
			printMat(visited,M,N);
			System.out.println("Done" + len);
			return;
		}
		if(isSafe(visited,x,y) && mat[x][y] == 1)
		{
			visited[x][y]=1;
			len++;
			for(int k=0;k< noOfDir;k++)
			{
				int ii = x+dirX[k];
				int jj = y+dirY[k];
				if(isSafe(visited,ii,jj))
					findpath(mat,ii,jj,m,n,visited,len);
			}
		}
	}
	
	private static boolean isSafe(int[][] visited, int x, int y) {
		// TODO Auto-generated method stub
		 if(x >= 0 && x < M && y >= 0 && y < N)
		        return true;
		return false;
	}
	private static void path(int[][] mat, int m, int n) {
		// TODO Auto-generated method stub
		int visited[][] = new int[M][N];
		for (int i=0;i<M;i++) {
			for (int j=0;j<N;j++) {
				visited[i][j] = 0;
			}
		}
		//int path[] = new int[M*N];
		findpath(mat,0,0,m,n,visited,0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][]={{1,0,1,0,0,1,1,1},
					{1,0,1,0,0,1,1,1},
				   	{1,0,1,1,0,1,1,1},
				    {1,1,0,0,0,1,1,1},
				    {0,1,1,0,0,0,1,1},
					{1,0,1,1,1,1,0,1},
					{1,0,0,0,0,1,0,1},
					{1,0,1,0,0,1,1,1}};
		path(mat,M,N);


	}

}
