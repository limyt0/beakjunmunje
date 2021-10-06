package study.a0923To;

import java.io.*;
import java.util.StringTokenizer;


public class BJ_16234_인구이동 {
		static int N, L, R;
		static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		br.close();
	}

}
