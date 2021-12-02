package study.a1104;

import java.io.*;
import java.util.*;

public class BJ_21610마법상어와비바라기 {
	static class Cloud {
		int r, c;

		public Cloud(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
    
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[][] wind;
	//1번 행과 N번 행을 연결했고, 1번 열과 N번 열
	//비바라기를 시전하면 (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴
	static int dr[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 }; // 좌부터 시계방향
	static int dc[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static ArrayList<Cloud> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N]; //바구니 배열
		wind = new int[M][2]; // 이동을 M번 명령, 구름이 d방향, s칸 이동[0] d, [1] s

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			//구름이 d방향, s칸 이동[0] d, [1] s
			wind[i][0] = Integer.parseInt(st.nextToken()); // d 방향
			wind[i][1] = Integer.parseInt(st.nextToken()); // s 칸
		}

		list = new ArrayList<Cloud>();
		//비바라기 시전시 (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다. 
		list.add(new Cloud(N - 2, 0));
		list.add(new Cloud(N - 1, 0));
		list.add(new Cloud(N - 2, 1));
		list.add(new Cloud(N - 1, 1));

		for (int i = 0; i < M; i++) {

			visit = new boolean[N][N];//방문체크
			int d = wind[i][0];
			int s = wind[i][1];
			move(d, s); //모든 구름이 di 방향으로 si칸 이동한다.
			add();//바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고,
			remove(); //물의 양이 2 줄어든다.
		}
		System.out.println(count());//최종 구해야 하는 물의 양의 합
		br.close();
	}
	
	private static int count() { //최종 구해야 하는 물의 양의 합
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += map[i][j];
			}
		}
		return cnt;
	}

	private static void remove() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2 && !visit[i][j]) { //이때 구름이 구름이 사라진 칸이 아니어야 한다.
					map[i][j] -= 2; //2 이상인  물의 양이 2 줄어든다
					list.add(new Cloud(i, j)); //
				}
			}
		}

	}

	private static void add() {
		//바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고,
		for (Cloud air : list) { //구름 리스트 
			int cnt = 0;
			int nr = -1, nc = -1;
			for (int i = 2; i <= 8; i += 2) {
				nr = air.r + dr[i];
				nc = air.c + dc[i];
				if (canMove(nr, nc) && map[nr][nc] > 0) { //8방탐색
					cnt++;

				}
			}
			map[air.r][air.c] += cnt; // 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
		}
		list.clear();

	}

	private static boolean canMove(int r, int c) {
		return (r >= 0 && c >= 0 && r < N && c < N);
	}

	private static void move(int d, int s) {

		for (Cloud air : list) {
			// 증가한 칸 (r, c)에 물복사버그 마법을 시전
			int nr = (air.r + N + dr[d] * s % N) % N;  // +N 음수 방지?,
			int nc = (air.c + N + dc[d] * s % N) % N;
			//구름위치+N+d방향*s칸 ㄱSz칸 % N d방향만큼 이동.
			visit[nr][nc] = true; //방문체크(사라질 구름)
			map[nr][nc] += 1; //각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
			air.r = nr;
			air.c = nc;
		}

	}

	
}


//https://namhandong.tistory.com/220