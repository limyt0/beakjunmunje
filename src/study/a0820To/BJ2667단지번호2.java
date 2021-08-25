package study.a0820To;

import java.io.*;
import java.util.*;
//인터넷 코드 참고했는데 틀림...
public class BJ2667단지번호2 {
	static int N; // 지도의 크기
	static int[][] arr; 
	static int count; // 단지집의 숫자
	static int[] drow = {-1,1,0,0}; //상하좌우
	static int[] dcol = {0,0,-1,1}; //상하좌우
	
	static ArrayList<Integer> result; // 단지 집의 수 저장 result.size()는 단지 수가 된다.
	
	static boolean[][] visited; // 방문 체크
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		//2차원 배열 지도
		arr = new int[N][N];
		
		//방문 체크
		visited = new boolean[N][N];
		
		//지도 배열 값 입력
		for(int i=0;i<N;i++) {
			String st = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = st.charAt(i) - 48; 
			}
		}
		
		//단지집의 숫자
		count = 0;

		//단지 집의 수 결과 저장
		result = new ArrayList<>();
		
		//지도 전체 탐색
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				//현재 위치의 값이 1이고 true라면
				if(arr[i][j]==1 && !visited[i][j]) {
					//맨 처음이기 때문에 count 1 증가
					count=1;
					Search(i,j);
					result.add(count);
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int c : result) System.out.println(c);
	}
	
	public static int Search(int x, int y) {
		visited[x][y] = true;
		
		//4방향 확인
		for(int i=0;i<4;i++) {
			int nx = x + drow[i];
			int ny = y + dcol[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(arr[nx][ny]==1 && !visited[nx][ny]) {
					Search(nx,ny);
					count++;
				}
			}
		}
		
		return count;
	}
	
	
	
}