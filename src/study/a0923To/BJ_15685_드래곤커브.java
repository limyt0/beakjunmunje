package study.a0923To;

import java.io.*;
import java.util.*;

//https://dublin-java.tistory.com/34 참고
//분석 필요함!
public class BJ_15685_드래곤커브 {
		static int N;
		static boolean[][] arr;
		static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new boolean[101][101];//격자 
		
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 시작 방향
			int g = Integer.parseInt(st.nextToken()); // 세대
			
			draw(x, y, getdirections(d,g));
		}
		
		cnt = 0;
		for(int i = 0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1]) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
	
	private static List<Integer> getdirections(int d, int g) {
		List<Integer> dirs = new ArrayList<>();
		dirs.add(d);
		for(int i = 0; i<g;i++) {
			for(int j = 0 ; j<=dirs.size() -1; j++) {
				int dir = (dirs.get(j) +1)%4;
				dirs.add(dir);
			}
		}
		return dirs;
	}
	
	private static void draw(int x, int y, List<Integer> dirs) {
		arr[x][y] = true;
		
		for(int dir: dirs) {
			switch(dir) {
			case 0://오른
				arr[++x][y] = true;
				break;
			case 1://위
				arr[x][--y] = true;
				break;
			case 2://왼
				arr[--x][y] = true;
				break;
			case 3://아래
				arr[x][++y] = true;
				break;
				
			}
		}
		
	}

}
