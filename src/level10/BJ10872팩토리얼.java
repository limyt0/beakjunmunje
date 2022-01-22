package level10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10872팩토리얼 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int Nfac = fact(N);
		System.out.println(Nfac);
		br.close();

	}

	private static int fact(int n) {
		if(n <= 1) return 1;
		return n * fact(n-1);
	} 

}
