package recursion;

public class Word1DArray {
	static int M=8;
	static int count=0;

	//static int dirX[]={1,1,-1,-1,0,0,1,-1};
	//static int dirY[]={1,-1,1,-1,1,-1,0,0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[]= {'c','g','o','r','g','g','o','r'};
				
	
	findword(mat,"gor");

}

	private static void findword(int[] mat, String string) {
		
		boolean visited[] = new boolean[M];
		for (int i=0;i<M;i++) {
			visited[i] = false;
		}// TODO Auto-generated method stub
		for (int i=0;i<M;i++) {
			System.out.println("Searching at" + i);
			if(visited[i] == true) {
				System.out.println("Skipping Searching at " + i);
				continue;
			}
			if(mat[i] == string.charAt(0) && visited[i] == false) {
					System.out.println("Starting Found the start at " + i);
					if( find(mat,string,i,0,visited)== true) {
						System.out.println("Found word at " + i + "till end");
					}
				}
				
			}		
	}

	private static boolean find(int[]mat, String string, int i, int pos,
			boolean[] visited) {
		// TODO Auto-generated method stub
		if  (string.length() == pos) {
			count++;
			System.out.println("Found the word till end in recusision at");
			return true;
		}
		if(i>=M)
			return false;
		if(string.charAt(pos) == mat[i]) {
			visited[i] = true;
			return find(mat,string,i+1,pos+1,visited);
		}
		visited[i] = false;
		return false;
	}
	}
