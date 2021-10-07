package study.a0930To;

import java.io.*;
import java.util.*;


public class BJ_17142_연구소3 {
	
	static class Virus { //바이러스 클래스 
        int row, col, time; 
 
        Virus(int r, int c, int time) { //row, col, 시간
            this.row = r;
            this.col = c;
            this.time = time;
        }
    }

    static int N, M;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0}; //사방, 바이러스가 상하좌우로 인접한 모든 빈 칸으로 동시에 복제
    static int[] dc = {0, 0, -1, 1};
    static List<Virus> viruses = new ArrayList<>(); //바이러스 
    static Virus[] active; //활성 바이러스
    static int resultMinTime = Integer.MAX_VALUE; //구할 최소값
    static int originEmptySpace = 0; //바이러스 수 체크
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());// 연구소의 크기(N*N)
        M = Integer.parseInt(st.nextToken());//바이러스의 개수 M
        
        arr = new int[N][N]; //연구소 크기만큼 배열
        active = new Virus[M]; //바이러스 배열
        //0:빈칸: 1은 벽 2: 바이러스 위치
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 0) {// //0:빈칸:
                    originEmptySpace++; //빈칸수 0의 수
                } else if (arr[i][j] == 2) { // 2: 바이러스 위치
                    viruses.add(new Virus(i, j, 0)); //바이러스 위치 일때
                }
            }
        }

        // solution
        if (originEmptySpace == 0) { // 빈공간 몇개? 0개 ., 더이상 퍼뜨릴 필요 없는 경우
            System.out.println(0);
        } else { // 
            combi(0, 0); //
            System.out.println(resultMinTime == Integer.MAX_VALUE ? -1 : resultMinTime);
        }
		
		
		br.close();
	}
	
	// 백트래킹으로 M 개의 바이러스를 선택하는 Combination 구현
    static void combi(int start, int selectCount) {
        if (selectCount == M) {
            spreadVirus(originEmptySpace); //빈칸수 param
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            active[selectCount] = viruses.get(i); //virus로 선언된 배열의 i번째 index값.
            combi(i + 1, selectCount + 1);
        }
    }

    // BFS 로 바이러스를 퍼트린다
    static void spreadVirus(int emptySpace) { //빈칸 0 param
        Queue<Virus> q = new LinkedList<>();// 
        boolean[][] infected = new boolean[N][N]; //감염 체크

        for (int i = 0; i < M; i++) {
            Virus virus = active[i]; // 활성화된 바이러스의 값을
            infected[virus.row][virus.col] = true;//true로?
            q.add(virus); //q에 활성화된 virus 넣음
        }

        while (!q.isEmpty()) { //queue가 빌때까지
            Virus virus = q.poll(); //하나씩 지워가면서

            for (int i = 0; i < 4; i++) {  //사방
            	
                int nr = virus.row + dr[i];
                int nc = virus.col + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue; //배열 index 범위 여부 체크
                if (infected[nr][nc] || arr[nr][nc] == 1) continue; //1은 벽이므로 벽도 체크

                if (arr[nr][nc] == 0) {
                    emptySpace--; //빈공간 0인 곳 감소
                }

                if (emptySpace == 0) { //빈공간이 0일 경우 == 다 채워지면
                    resultMinTime = Math.min(resultMinTime, virus.time + 1); // 구할 최소값.
                    return;
                }

                infected[nr][nc] = true; //현재 감염됨 
                q.add(new Virus(nr, nc, virus.time + 1)); //
            }
        }
    }

}
