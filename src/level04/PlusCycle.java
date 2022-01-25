package level04;

import java.util.Scanner;

public class PlusCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int N2 = N;
		int count = 0;
		do {
			N =  (((N / 10) + (N%10))%10)+(N%10)*10;
			count ++;
		}
		while(N != N2) ;
		  System.out.println(count);
		
	}

}
