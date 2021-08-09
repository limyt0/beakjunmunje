package 혼자연습;

import java.io.*;
import java.util.*;
//검색으로 푼거라 연습필요.
public class _HW20210805백준2493탑 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<int[]> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		for(int i =1; i<=N; i++) {
			int H = Integer.parseInt(st.nextToken());//높이
			if(stack.isEmpty()) {//스택 비면 0출력후 peek push.
				sb.append("0 ");
				stack.push(new int[] {i, H});
			} else {
				while(true) {
					if(stack.isEmpty()) {
						sb.append("0 ");
						stack.push(new int[] {i, H});
						break;
					}
					int[] peekstack = stack.peek();//가장위 스택
					
					if(peekstack[1] > H) {//현재탑보다 높으면
						sb.append(peekstack[0]+" ");//출력후
						stack.push(new int[] {i, H});// 현재 스택에 push.
						break;
					}else {
						stack.pop();
					}
				}
			}
		}
		System.out.println(sb+"\n");
		br.close();
	}

}
