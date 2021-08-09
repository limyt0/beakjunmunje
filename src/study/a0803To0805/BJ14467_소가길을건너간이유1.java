package study.a0803To0805;

import java.io.*;
import java.util.StringTokenizer;
//풀었음
public class BJ14467_소가길을건너간이유1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cow[] = new int[N];//소들의 현재 위치 저장용.
		//배열을 -1로 초기화. 자동 0 초기화 방지.
		for(int i = 0;i<N;i++) {
			cow[i] = -1;
		}
		//
		int cnt = 0; //건너간 횟수 카운트
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num= Integer.parseInt(st.nextToken())-1;// n-1번쨰 소. 1~10번까지의 소,->cow[0]~cow[9] 
			int state = Integer.parseInt(st.nextToken()); //현재 소 위치
			if(cow[num] != -1 && cow[num] != state) { //초기화값이 아니면서 값이 다를때.
				cnt++;//건너간 횟수
			}
			cow[num] = state;//n번째 소는 state 위치에 있다.
		}
		System.out.println(cnt+"\n");
		br.close();
	}
}
