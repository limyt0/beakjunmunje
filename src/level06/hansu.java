package level06;

import java.util.Scanner;

public class hansu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		if(N <=99) {
			System.out.println(N);
		}else {
			int cnt = 99;//99까진 자기자신과 같으니 99부터 셈.
			for(int i = 100;i<=N;i++) {
				int n100 = i/100 ; //어차피 체크해야할 수는 세자리 밖에 없음.
				int n10 = (i/10)%10;
				int n1 = i%10;
				if(n100-n10 == n10-n1) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
