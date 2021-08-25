package study.a0805To0812;

import java.io.*;
import java.util.*;

//
public class BJ11725_트리의부모찾기 {
	static int[] parents;
	static List<Integer>[] list;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());		
		list = new List[N+1];// 인텍스 체크를 1부터 하기 위함.
		parents = new int[N+1];//차례대로부모저장 
		for(int i = 1; i<=N;i++) {
			list[i] = new ArrayList<>();//
		}
		visited = new boolean[N+1];
		for(int i =0;i<N-1;i++) {//1은 제외하므로 N-1
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());//
			int b = Integer.parseInt(st.nextToken());//
			//트리 저장
			list[a].add(b);
			list[b].add(a);
		}
		dfs(1);
		for(int i =2;i<=N;i++) {
			sb.append(parents[i]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	static void dfs(int p) { //
		visited[p] = true;
		for(int i : list[p]) {//i번째의 부모는 p
			if(!visited[i]) {//방문 체크
				parents[i] = p; //방문한적 없으면 지금 노드가 부모 노드가 됨. 부모노드를 먼저 방문하기 때문. 
				dfs(i);
			}
		}
	}
}
