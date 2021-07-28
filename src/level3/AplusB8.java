package level3;

import java.util.Scanner;

public class AplusB8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i =0; i<n;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int num = A+B;
			System.out.println("Case #"+(i+1)+": "+A+" + "+B+" = "+num);
		}
	}

}
