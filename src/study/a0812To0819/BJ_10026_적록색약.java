package study.a0812To0819;
import java.io.*;

//인터넷 코드 참조
public class BJ_10026_적록색약 {
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static char[][] arr;
	static boolean[][] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for(int i =0;i<N;i++) {
			String st = br.readLine();
			for(int j = 0; j<N; j++) {
				arr[i][j] = st.charAt(j);
			}
		}
		visited = new boolean[N][N];
		int result1 =check(0);//적록색약아닌사람,
		visited = new boolean[N][N];//초기화
		int result2 =check(0);//적록색약맞는사람
		System.out.println(result1+" "+result2);
		br.close();
	}
	private static int check(int result) {
		for(int i =0; i<N; i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j, arr[i][j]);
					result++;
				}
				if(arr[i][j] == 'G') {//G일때 R로 덮어씀. 덮어쓰면  result2에서 색약으로 체크됨
					arr[i][j] = 'R';
				}
			}
		}
		return result;
	}
	private static void dfs(int r, int c, char ch) {
		visited[r][c] =true;//
		for(int i = 0; i<4;i++) {//사방탐색
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr < 0 || nc < 0 || nr >=N || nc >= N || visited[nr][nc]|| arr[nr][nc] != ch) {//범위 벗어나거나 방문하면 continue
				continue;
			}
			dfs(nr,nc, ch);
		}
		
	}
}
