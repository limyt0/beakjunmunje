package level05;

import java.util.Scanner;

public class OverAvg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int i = 0; i<C;i++) {
			int N = sc.nextInt();
			double avg = 0;
			int[] point = new int[N];
			for(int j=0; j<N;j++) {
				point[j] = sc.nextInt();
				avg += point[j];
			}
			avg = avg / (double)N;
			int avgcnt = 0;//평균 넘는 사람수
			for(int j=0; j<N;j++) {
				if(avg < point[j]) {
					avgcnt++;
				}
			}
			double result = (avgcnt / (double)N)*100;
			System.out.println(String.format("%.3f",  result)+"%");
		}
	}
}
