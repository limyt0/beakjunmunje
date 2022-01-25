package level07;

import java.util.Scanner;

public class NumberSum_11720 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt(); 
		String numsc = sc.next();
		int result = 0;
		for(int i = 0; i<T; i++) {
			result += (numsc.charAt(i)-48);
		}
		System.out.println(result);
	}
}
