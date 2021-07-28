package level3;

import java.util.Scanner;

public class hap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result=0;
		for(int i = 0; i<n;i++) {
			result += i+1;
		}
		System.out.println(result);
	}

}
