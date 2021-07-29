package level5;

import java.util.Scanner;

public class Nameoji {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nameoji = new int[42];
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<10; i++) {
			int n = sc.nextInt();
			int k = n %42;
			nameoji[k] += 1;
		}
		int cnt = 0;
		for(int i = 0; i<42; i++) {
			if(nameoji[i] !=0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
