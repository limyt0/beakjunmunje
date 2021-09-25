package study.a0923To;
import java.io.*;
import java.util.*;

//https://devje8.tistory.com/11 참고
//bfs? 로도 풀수있다??
public class BJ_16236_아기상어 {
	static int N, time, sr, sc, size, count;
	static int[][] arr;
	static ArrayList<Info> fishes;
	static int[] dr = {-1, 1, 0,0};
	static int[] dc = {0, 0, -1, 1};
	
	//물고기 위치와 거리 담을 클래스
	static class Info{
		int row, col, dist;
		public Info(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int size = 2; //초기 2로 세팅
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					sr = i;
					sc = j;
					arr[i][j] =0;
				}
			}
		}
		
		while(true) {
			fishes = new ArrayList<Info>(); //먹을수 있는 물고기의 정보 담을수 있는 arraylist
			Queue<Info> q = new LinkedList<Info>();
			boolean visited[][] = new boolean[N][N]; //방문 표시
			q.offer(new Info(sr, sc, 0));//상어 위치 q에 삽입. 물고기 먹어서 0으로 갱신
			visited[sr][sc] = true;
			
			while(!q.isEmpty()) {
				Info shark = q.poll();
				
				for(int d = 0; d<4; d++) {
					int nr = shark.row + dr[d];
					int nc = shark.col + dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc >=N) continue;//범위 체크
					if(visited[nr][nc]) continue;//방문 체크
					
					if(1<= arr[nr][nc] && arr[nr][nc] < size) {
						q.offer(new Info(nr, nc, shark.dist+1));//상어 위치 갱신
						fishes.add(new Info(nr, nc, shark.dist+1)); //먹이 리스트 삽입
						visited[nr][nc] = true;
					}
					//먹을수 없지만 지나갈 수 있는경우
					else if(arr[nr][nc] == size || arr[nr][nc] == 0) {
						q.offer(new Info(nr, nc, shark.dist+1));
						
						visited[nr][nc] =true;
					}
				}
			}
			
			//사이즈가 0인 경우 먹을 수 있는 물고기가 없는 경우.
			if(fishes.size() == 0) {
				System.out.println(time);
				return;
			}
			
			Info eatingFish = fishes.get(0);
			for(int i = 1; i<fishes.size(); i++) {
				if(fishes.get(i).dist < eatingFish.dist) {
					//거리가 최소인 물고기로 갱신
					eatingFish = fishes.get(i);
				}
				
				if(eatingFish.dist == fishes.get(i).dist) {
					//거리가 같은 경우 위쪽 물고기가 우선
					if(eatingFish.row > fishes.get(i).row) {
						eatingFish = fishes.get(i);
					}
				}
			}
			
			time += eatingFish.dist; //먹을 물고기 거리를 time에 추가
			count++; //먹은 카운트 증가
			arr[eatingFish.row][eatingFish.col] = 0;
			
			if(count == size) {
				size++;//상어 사이즈 1 증가
				count = 0;//다시 카운트는 0으로 초기화
			}
			
			//상어 위치 갱신
			sr = eatingFish.row;
			sc = eatingFish.col;
		}
		
		
		
		//br.close();

	}
	
	

}
