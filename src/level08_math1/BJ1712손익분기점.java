package level08_math1;

import java.io.*;
import java.util.*;

public class BJ1712손익분기점 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int result = 0;
		// A+Br =< Cx 일때 X 의 값. 
		//**C-B가 음수이면 무조건 x값이 뭐든간에 손익분기점이 불가능.
		if(C-B < 1) {
			result = -1;
		}else {
			result = (A / (C-B)) + 1;//while로 썼다가 틀렸었음.
		}
		
		
		
		System.out.println(result);
	}
}
