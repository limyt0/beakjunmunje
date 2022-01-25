package level03;

import java.util.Scanner;

public class gugudan {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i =0; i<9;i++) {
			int num = N*(i+1);
			System.out.println(N+" * "+(i+1)+" = "+num);
		}
	}

}
