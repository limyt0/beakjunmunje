package level10;

import java.io.*;

public class BJ10870피보나치수5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result =  pb(N);
		System.out.println(result);
		br.close();

	}

	private static int pb(int n) {
		if(n <= 1) return n;
		return pb(n-1)+pb(n-2);
	}

}
