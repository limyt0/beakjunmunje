package study.a0812To0819;

import java.io.*;
import java.util.*;

public class BJ_2606바이러스 {
	static boolean visited[];
	static List<Integer>[] list;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int com = Integer.parseInt(br.readLine());//컴퓨터 수
		int T = Integer.parseInt(br.readLine());	//쌍의 수
		list = new List[com+1];// 인텍스 체크를 1부터 하기 위함.
		visited = new boolean[com+1];
		for(int i =1;i<=com;i++) {
			list[i] =  new ArrayList<>();
		}
		
		StringTokenizer st;//= new StringTokenizer(br.readLine(), " ");
		for(int i =1; i<=T; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
			
		}
		dfs(1);
		int cnt = 0;
		for(int i =2 ;i<=com; i++) {//방문안함\-> 감염 안됨??
			if(visited[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
		br.close();
	}
	private static void dfs(int n) {
		visited[n] = true; 
		for(int i: list[n]) { //list[n]은 arraylist
			if(!visited[i]){
				dfs(i);
			}
		}		
	}
}
