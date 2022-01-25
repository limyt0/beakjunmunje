package level05;

import java.util.Scanner;

public class numberth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int num = A*B*C;
		int []  arr = new int[10];
		while(num >0) {
			int nameji = num % 10;
			arr[nameji] +=1;
			num /= 10;
		}
		
		for(int i = 0; i<10; i++) {
			System.out.println(arr[i]);
		}
	}
}
