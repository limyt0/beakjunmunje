package level05;

import java.util.Scanner;

public class OXquiz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i =0;i<T;i++) {
			String ox = sc.next();
			int cnt = 0;
			int point =0;
			for(int j = 0; j<ox.length(); j++) {
				if('O' ==ox.charAt(j)) {
					cnt += 1;
					point += cnt;
				}else if('X' == ox.charAt(j)){
					cnt = 0;
				}
			}
			System.out.println(point);
		}

	}
}
