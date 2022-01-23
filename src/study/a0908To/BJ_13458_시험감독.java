package study.a0908To;

import java.io.*;
import java.util.*;

public class BJ_13458_시험감독 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int N = Integer.parseInt(br.readLine()); //시험장 수
		int [] arr = new int[N];//응시자 배열
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {//응시자수 저장
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st.nextToken());//총감독관이 감시할 수 있는 수
		int C = Integer.parseInt(st.nextToken());//부감독관이 한시험장에서 감시할 수 있는 응시자 수.
		
		long result = 0; //int로 하니 틀렸다고 나옴.
		for(int i = 0; i<N;i++) {
			arr[i] -= B; //각 배열별 총감독 감시가능 먼저 빼고, 
			result++;
			
			if(arr[i]>0) {//남은 인원이 0보다 크면
				if(arr[i]%C == 0) { //딱 나누어 떨어지면
					result += (arr[i]/C);
				}else { //나누어 떨어지지 않으면 남은 수가 C보다 작을 것이므로.
					result += (arr[i]/C+1);
				}
			}
		}
		System.out.println(result);
		br.close();

	}

}

//참고: https://hibee.tistory.com/84
