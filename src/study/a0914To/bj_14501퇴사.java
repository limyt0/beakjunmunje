package study.a0914To;

import java.io.*;
import java.util.*;
//점화식: P[i] = max(P[i+1], P[i] + P[i + T[i]])
public class bj_14501퇴사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] T=new int[N+2];//상담을 완료하는데 걸리는 기간 , N+1를 0으로 초기화
		int [] P=new int[N+2];//상담을 했을 때 받을 수 있는 금액, N+1를 0으로 초기화
		int result = 0;
		for(int i =1;i<=N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
			T[i] =  Integer.parseInt(st.nextToken());
			P[i] =  Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = N; i>=1; i--) { //거꾸로부터 해야 구할수 있음,, N+1를 0으로 초기화
				if(i+ T[i]>N+1) {P[i] = P[i+1]; //N+1일째에는 회사에 없기 때문에... 날짜 범위.  
					//(거꾸로부터 반복문을 돌렸으므로) 이전값이 들어감.
				} else {
					P[i] = Math.max(P[i+1], P[i]+P[i+T[i]]);// 이전값, 현재값+현재값에서 시간더한번째값.
					//굳이 치환?->중간 빈 날짜 있는 경우 고려?
						
					result = Math.max(result, P[i]);
				}
		}
		/*for(int i = N; i>=1; i--) { //거꾸로부터 해야 구할수 있음,
			System.out.println("i"+i);
				if(i==N ) {//이거 따로 안 해두면 indexout
					if(T[i] != 1) {
						P[i] = 0;//마지막 날은 1이 아닐 경우 불가능하므로 0으로 초기화
					}//else는 어차피 값 이미 입력으로 받았으니 의미 없을듯
				}else {
					if(i+ T[i]>N+1) {P[i] = P[i+1]; //N+1일째에는 회사에 없기 때문에... 날짜 범위.  &&i<N안하면 indexoutof뜸
					//(거꾸로부터 반복문을 돌렸으므로) 이전값이 들어감.
					}else {
						P[i] = Math.max(P[i+1], P[i]+P[i+T[i]]);// 이전값, 현재값+현재값에서 시간더한번째값.
						//굳이 치환?->중간 빈 날짜 있는 경우 고려?
						
						result = Math.max(result, P[i]);
					}
				}			
			
		}*/
		System.out.println(result);
		
		br.close();
	}

}


//참고:https://sihyungyou.github.io/baekjoon-14501/