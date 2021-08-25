package study.a0805To0812;

import java.io.*;
import java.util.*;

//수정 필요
public class BJ11725_트리의부모찾기2 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int [] node = new int[N+1];//index에 해당하는 부모를 담을 배열.
		//0-> 부모. 
		for(int i =0; i<N-1; i++) { //N개중 1은 제외
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());//부모값.
			int idx = Integer.parseInt(st.nextToken());//인덱스
			
			if(idx == 1) {//1이 무조건 부모.
				node[parent] = idx; 
			}else if(parent == 1) {
				node[idx] = parent; //1이 무조건 부모.2
			}else if(node[idx] ==0) { //현재 값이 없으니 넣는 경우
				node[idx] = parent;//
			}else {//0이 아닐 경우. 값이 이미 있으므로 노드가 뒤집힌 경우
				node[parent] = idx;
			}
		}
		for(int i = 2; i<=N; i++) {//2번째(=idx-1)이므로 idx=1부터 시작.
			sb.append(node[i]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
