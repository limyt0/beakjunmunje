package level5;

import java.util.Scanner;

public class Max {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nth=0;
		int max = 0;
		for(int i = 0; i<9; i++) {
			int n = sc.nextInt();
			if(max<n) {
				max = n;
				nth = i+1;
			}	
		}
		System.out.println(max);
		System.out.println(nth);
	}
}
