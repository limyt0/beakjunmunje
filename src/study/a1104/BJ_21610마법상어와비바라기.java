package study.a1104;

import java.io.*;
import java.util.*;

public class BJ_21610마법상어와비바라기 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[][] wind;
	static int dr[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 }; // 좌부터 시계방향
	static int dc[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static ArrayList<Air> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		wind = new int[M][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			wind[i][0] = Integer.parseInt(st.nextToken()); // d
			wind[i][1] = Integer.parseInt(st.nextToken()); // s
		}

		list = new ArrayList<Air>();
		list.add(new Air(N - 2, 0));
		list.add(new Air(N - 1, 0));
		list.add(new Air(N - 2, 1));
		list.add(new Air(N - 1, 1));

		for (int i = 0; i < M; i++) {

			visit = new boolean[N][N];
			int d = wind[i][0];
			int s = wind[i][1];
			move(d, s);
			add();
			remove();
		}
		System.out.println(count());
		br.close();
	}
	
	private static int count() {
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
				if (map[i][j] >= 2 && !visit[i][j]) {
					map[i][j] -= 2;
					list.add(new Air(i, j));
				}
			}
		}

	}

	private static void add() {
		for (Air air : list) {
			int cnt = 0;
			int nr = -1, nc = -1;
			for (int i = 2; i <= 8; i += 2) {
				nr = air.r + dr[i];
				nc = air.c + dc[i];
				if (canMove(nr, nc) && map[nr][nc] > 0) {
					cnt++;

				}
			}
			map[air.r][air.c] += cnt;
		}
		list.clear();

	}

	private static boolean canMove(int r, int c) {
		return (r >= 0 && c >= 0 && r < N && c < N);
	}

	private static void move(int d, int s) {

		for (Air air : list) {
			int nr = (air.r + N + dr[d] * s % N) % N;
			int nc = (air.c + N + dc[d] * s % N) % N;

			visit[nr][nc] = true;
			map[nr][nc] += 1;
			air.r = nr;
			air.c = nc;
		}

	}

	static class Air {
		int r, c;

		public Air(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
    
}


//https://namhandong.tistory.com/220