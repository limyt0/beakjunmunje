package study.a0923To;
import java.io.*;
import java.util.*;

//https://data-make.tistory.com/524 참고한 코드
public class BJ_17144미세먼지안녕 {
	static int R, C ,T;
	static int cleaner = -1;
	static Queue<Dust> dusts;
	static int[][] arr;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class Dust{
		int col, row, w;
		
		public Dust(int row, int col, int w) {
			super();
			this.col = col;
			this.row = row;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		
		arr = new int[R][C];
		for(int i =0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(cleaner == -1 && arr[i][j] == -1) {
					cleaner = i;
				}
			}
		}
		
		for(int t = 0; t< T; t++) {
			//미세먼지 공간 확인
			checkDust();
			
			//미세먼지 확산
			spread();
			
			//공기청정기 작동
			operate();
		}
		
		int res = 0;
		for(int i =0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(arr[i][j] == -1) continue;
				res += arr[i][j];
			}
		}
		
		System.out.println(res);
		
		br.close();
	}

	
	private static void checkDust() {
		
		dusts = new LinkedList<>();
		
		for(int i =0; i<R; i++) {
			for(int j = 0;j<C;j++) {
				if(arr[i][j] == -1 || arr[i][j] ==0) continue;
				//미세먼지가 있는 공간과 미세먼지 양
				dusts.add(new Dust(i,j,arr[i][j]));
			}
		}
		
	}

	private static void spread() {

		while(!dusts.isEmpty()){
			
			Dust now = dusts.poll();
			//확산될 먼지가 없으면
			if(now.w < 5) continue;
			//확산되는 양은 Ar, c/5
			int amountOfSpread = now.w / 5;
			int cnt = 0;
			//인접한 방향으로 확산
			for(int d = 0; d < 4; d++) {
				
				int nr = now.row + dr[d];
				int nc = now.col + dc[d];
				//범위 벗어나면
				if(nc < 0 || nc >= C || nr <0 || nr >=R) continue;
				//공기청정기가 있으면
				if(arr[nr][nc]== -1) continue;
				arr[nr][nc] += amountOfSpread;
				cnt++;
			}
			
			// 남은 미세먼지 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수)
			arr[now.row][now.col] -= amountOfSpread * cnt;
		}
		
	}


	//바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동
	private static void operate() {
		int top = cleaner;
		int down = cleaner + 1;
		
		//위쪽 공기청정기의 바람은 반시계방향 순환
		//아래로 당기기
		for(int i = top -1; i> 0; i--)
			arr[i][0] = arr[i-1][0];
		//왼쪽으로 당기기
		for(int i = 0; i<C-1; i++)
			arr[0][i] = arr[0][i+1];
		//위로 당기기
		for(int i = 0; i< top; i++)
			arr[i][C-1] = arr[i+1][C-1];
		//오른쪽으로 당기기
		for(int i = C-1; i>1;i--) 
			arr[top][i] = arr[top][i-1];
		//공기청정기에서 부는 바람은 미세먼지가 없는 바람
		arr[top][1] = 0;
		
		//아래쪽 공기청정기의 바람은 시계방향으로 순환
		// 위로 당기기
        for (int i = down + 1; i < R - 1; i++) 
            arr[i][0] = arr[i + 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) 
            arr[R - 1][i] = arr[R - 1][i + 1]; 
        // 아래로 당기기
        for (int i = R - 1; i > down; i--) 
            arr[i][C - 1] = arr[i - 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) 
            arr[down][i] = arr[down][i - 1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        arr[down][1] = 0;

		
	}

}
