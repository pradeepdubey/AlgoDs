package recursion;

import java.util.ArrayList;

import recursion.AllPath2DMat.path;


public class AllPath2DMat{
	static public class path {
		int x;
		int y;
	}
	public static int count =0;
	public static int M = 4;
	public static int N = 4;
	public static int dirX[] = {0,1};
	public static int dirY[] = {1,0};
	
	public AllPath2DMat() {
		// TODO Auto-generated constructor stub
	}

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
		int len=0;
		ArrayList<path> plist= new ArrayList<path>();
		find(maze,visited,0,0,plist,len);
		
	}

	private static void find(int[][] maze, int[][] visited, int i, int j,ArrayList<path> plist, int len)
	{
		// TODO Auto-generated method stub
		if(i==M-1 && j ==N-1)
		{
			count++;
			visited[i][j] = 1;
			path p = new path();
			p.x=i;
			p.y=j;
			plist.add(p);
			len++;
			System.out.println("Found the Cheeze at the end at path no " + count);
			//printMat(visited);
			printList(plist,len);
			return;
		}
		
		if(maze[i][j] == 1)
		{
			visited[i][j]=1;
			path p = new path();
			p.x=i;
			p.y=j;
			plist.add(p);
			len++;
			if(isSafe(i+1,j))
					find(maze,visited,i+1,j,plist,len);
			if(isSafe(i,j+1))
					find(maze,visited,i,j+1,plist,len);
	
	
		}
		
	}

	private static void printList(ArrayList<path> plist, int len) {
		// TODO Auto-generated method stub
		for (path p : plist)
		    System.out.print(p.x + "," +p.y + "->");
		System.out.println("");
		
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
