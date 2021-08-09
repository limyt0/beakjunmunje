package 혼자연습;

import java.io.*;
import java.util.*;
//늦게 푼 문제.
public class Solution_d3_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new ArrayDeque<>();
		
		int T = 10;;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int nth= Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			//조건에 제시된 수 queue에 담기.
			while(st.hasMoreTokens()) { //queue에 하나씩 값 넣기.
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			int cnt= 1;
			//사이클 작업 queue로 돌리기
			int q_nowp = queue.peek();//현재 queue의 peek값.
			while(q_nowp > 0) { // 0이하면 더이상 감소 못함
				q_nowp = queue.peek();
				if(cnt > 5){ //5초과마다 사이클.
					cnt= 1;
				}
				if(q_nowp - cnt <= 0){
					queue.offer(0);
					queue.poll();
					
					break;
				}else {
					
					queue.offer(q_nowp-cnt);
					queue.poll();
					cnt++;
				}
				
			}
			
			sb.append("#").append(test_case).append(" ");
			//queue가 빌때까지 입력.
			while(!queue.isEmpty()) {
				sb.append(queue.peek()).append(" ");
				queue.poll();
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
