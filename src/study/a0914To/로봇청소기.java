package study.a0914To;

import java.io.*;
import java.util.StringTokenizer;

public class 로봇청소기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st =new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		for(int i = 0; i<N; i++) {
			st =new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}

}