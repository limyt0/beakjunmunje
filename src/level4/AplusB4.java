package level4;

import java.util.Scanner;
//-----------인터넷 코드 참고함-----------
public class AplusB4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a= -1;int b= -1;
		while(sc.hasNextInt()) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a+b);
		}
		sc.close();
	}
}
