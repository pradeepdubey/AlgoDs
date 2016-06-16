package recursion;

public class MatrixWord {
	static int M=4, N=8;
	static int count=0;

	
	static int dirX[]={-1,1,-1,-1,0,0,1,1};
	static int dirY[]={0,-1,1,-1,1,-1,0,1};
	private static void printMat( char[][] mat, int k, int l) {
		//System.out.println("Pritning Vsited matrix for " + k + "  " + l);
		for (int i=0;i<M;i++) {
			for (int j=0;j<N;j++) {
				System.out.print(mat[i][j] + "  ");
			}
			System.out.println("");
		}// TOD
	}
	private static void printIntMat( int[][] mat, int k, int l) {
		System.out.println("Pritning Solution matrix");
		for (int i=0;i<M;i++) {
			for (int j=0;j<N;j++) {
				System.out.print(mat[i][j] + "  ");
			}
			System.out.println("");
		}// TOD
	}
	private static void findword(char[][] mat, String string) {
		
		//2D Array to BackTrack and Store the Words Found
		int visited[][] = new int[M][N];
		for (int i=0;i<M;i++) {
			for (int j=0;j<N;j++) {
				visited[i][j] = 0;
			}
		}// TODO Auto-generated method stub
		for (int i=0;i<M;i++) {
			for (int j=0;j<N;j++) {
				// If already its part of the word found skip
				if(visited[i][j] == 1) {
					//System.out.println("Skipping Searching at " + i + "," + j);
					continue;
				}
				// If we have found the starting letter of the word then search for word around here
				if(mat[i][j] == string.charAt(0)) {
					//System.out.println("Found the starting char at " + i + "  "+ j);
					if( find(mat,string,i,j,0,visited)== 1) {
						System.out.println("Found the word at " + i + "  "+ j );
					}
				}
				
			}
		}
		printIntMat(visited,M,N);
		
	}

	private static int find(char[][] mat, String string, int i, int j, int pos,
			int[][] visited) {
		// TODO Auto-generated method stub
		
		int result = 0;
		// Reached the end of the word and still positive, word found
		if  (string.length() == pos) {
			//System.out.println("Reached till end in recursion");
			count++;
			result = 1;
			return result;
		}
		if(string.charAt(pos) == mat[i][j] && visited[i][j] == 0) {
			
			//System.out.println(" Setting the visited for " + i + " "+ j);
			visited[i][j] = 1;
			for (int k=0;k<N;k++) {
				int ii = i + dirX[k];
				int jj = j + dirY[k];
				if(ii<0 || ii>=M || jj < 0 || jj >= N) {
					//System.out.println("Not Calling for "+ ii + " " + jj+ " In the circlar way aroud " + i + " "+ j);
					continue;
				}
				//System.out.println("Calling for "+ ii + " " + jj+ " In the recursive circlar way aroud " + i + " "+ j);
				 if( find(mat,string,ii,jj,pos+1,visited) == 1) {
					//printIntMat(visited,i,j);
					result = 1;
					return result;
					
				 } 				
			}
			
			//System.out.println(" Unsetting the visited for " + i + " "+ j);
			// If we reach here, then we have not found the complete word, unset the visited on backtrack
			visited[i][j] = 0;
			//printMat(visited,i,j);
		}
	
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char mat[][]= {{'c','o','h','s','d','g','o','t'},
					  {'c','g','o','r','o','g','s','o'},
					  {'c','g','g','r','o','o','s','o'},
					  {'c','g','h','r','o','t','s','o'}};
	
		printMat(mat,M,N);
		findword(mat,"got");

}


	}
