package study.a0812To0819;

import java.io.*;
import java.util.*;

public class BJ_17281야구공 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int [] arr = new int[9];
			while(st.hasMoreTokens()) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
		}
		br.close();
	}

}
