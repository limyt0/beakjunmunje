package level3;

import java.util.Scanner;

public class Xbodajac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		for(int i =0; i<N; i++) {
			int num = sc.nextInt();
			if(X > num) {
				System.out.print(num+" ");
			}
		}
		
	}

}
