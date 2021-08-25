package study.a0805To0812;

import java.io.*;
import java.util.*;

public class BJ11725_트리의부모찾기_3 {
	static int N;
    static int[] parent;
    static boolean[] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];// 인텍스 체크를 1부터 하기 위함.

		for(int i = 1; i<=N;i++) {
			list[i] = new ArrayList<>();//??
		}
		
		for(int i =0; i<N-1; i++) { //N개중 1은 제외
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());//
			int b = Integer.parseInt(st.nextToken());//
			
			//트리 저장
			list[a].add(b);
			list[b].add(a);
		}
		//BfS 통해 트리 순회하여 부모 찾기.
		parent = new int[N+1];
		visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(1);
		
		visited[1] = true;
        while(!q.isEmpty()){
            int k = q.poll();
            for(int index : list[k]){
                if(!visited[index]){// 아직 미방문한 각 노드를 다음 탐색 대상으로 넣고
                    
                    // 각 노드의 부모를 현재 노드로 지정
                    q.offer(index);
                    visited[index] = true;
                    parent[index] = k;
                }
            }
        }
        // 부모 찾기 완료 
        
        for(int i=2; i <= N; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
	}

}
















/*
   //인터넷 코드 참고DFS
   public class Main{

   static int n;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for(int i=1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        parent = new int[n+1];
        visited = new boolean[n+1];
        dfs(1);
        
        StringBuilder sb = new StringBuilder();
        for(int i=2; i <= n; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    
    private static void dfs(int u){
        for(int v : graph[u]){
            if(!visited[v]){
                parent[v] = u;
                visited[v] = true;
                dfs(v);
            }
        }
    }
}*/