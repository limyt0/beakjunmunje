package level2;

import java.util.Scanner;

public class Alarm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h= sc.nextInt();
		int m= sc.nextInt();
		if(m-45 >0) {
			m -= 45;
		}else if(h-1>=0) {
			h -=1;
			m += 15;
		}else {
			h += 23;
			m +=15;
		}
		System.out.println(h+" "+m);
		
	}
	

}
