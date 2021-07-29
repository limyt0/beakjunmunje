package level5;

import java.util.Scanner;

public class MinMax {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = 1000000;
		int max = -1000000;
		for(int i = 0; i<N;i++) {
			int k = sc.nextInt();
			if(min > k)min = k;
			if(max < k)max = k;
		}
		System.out.println(min+" "+max);
	}
}
