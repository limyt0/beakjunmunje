package level02;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ly = sc.nextInt();
		if((ly % 4 == 0 && ly % 100 != 0) || ly % 400 == 0) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}

}
