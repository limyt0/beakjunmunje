package study.a0820To;

import java.io.*;
import java.util.*;
//인터넷 코드 참고 많이 함...
public class BJ2667단지번호 {
	static int [][] arr;
	static boolean[][] visited;
	//static int[][] parents;
	static int N;
	static int cnt;
	static int[] drow = {1,-1,0,0};
	static int[] dcol = {0,0,1,-1};
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		//parents = new int[N][N];
		arr = new int[N][N];
		
		visited = new boolean[N][N];
		for(int i = 0; i<N;i++) {
			String st = br.readLine();
			for(int j = 0; j<N;j++) {
				arr[i][j] = st.charAt(j) - 48; 
			}
		}
		cnt = 0;//단지 집 수
		
		result = new ArrayList<>();//단지 집 수 결과값
		for(int i =0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					cnt = 1;//처음이라 1 증가?
					Search(i,j);
					result.add(cnt);
				}
			}
		}
		//Collections.sort(result);??
		System.out.println(result.size());
		for(int c: result) sb.append(c).append("\n");
		System.out.println(sb);
		br.close();
	}

	private static void Search(int row, int col) {
		visited[row][col] = true;//
		
		//4방 확인
		for(int i=0;i<4;i++) {
			int nrow = row + drow[i];
			int ncol = col + dcol[i];
			if(nrow>=0 && ncol>=0 && nrow<N && ncol<N) {
				if(arr[nrow][ncol] == 1 && !visited[nrow][ncol]) {
					Search(nrow, ncol);
					cnt++;
				}
			}
		}
	}
	
	
	
}