package level5;

import java.util.Scanner;

public class avg {
  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		double avg = 0;
		int [] arr = new int[N];
		for(int i = 0; i<N;i++) {
			int k = sc.nextInt();
			if(max < k) {
				max = k;
			}
			arr[i] = k;
		}
		for(int i = 0;i<N;i++) {
			double k = (arr[i] / (double)max)*100;
			//System.out.println("tset"+i+": "+k);
			avg += k;
		}
		System.out.println(avg/N);
	}

}
