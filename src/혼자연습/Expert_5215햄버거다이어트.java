package 혼자연습;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Food{
	int taste;
	int kal;
	boolean visit;
	Food(int taste, int kal){
		this.taste = taste;
		this.kal = kal;
	}
}

public class Expert_5215햄버거다이어트 {

	public static void main(String[] args) throws  IOException {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(br.readLine());
		ArrayList<Food> arr = new ArrayList<>();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer NL = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(NL.nextToken());
			int L = Integer.parseInt(NL.nextToken());
			
			for(int i =0; i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int taste = Integer.parseInt(st.nextToken());
				int kal = Integer.parseInt(st.nextToken());
				arr.add(new Food(taste, kal));
			}
			int maxtaste = 0;
			for(int i = 0; i<N; i++){
				maxtaste = Math.max(combs(arr, 0, N,i, L, maxtaste), maxtaste) ; //경우의 수별로 더하여 총합을 리턴 후 최대값과 비교.
				
			}
			System.out.println("#"+test_case+" "+maxtaste);
		}
		br.close();
	}

	private static int combs(ArrayList<Food> arr, int depth, int n, int r, int limitkal, int max) {//경우의 수별로 더하기

		
		if(r ==0) {
			max = Math.max(sumtaste(arr, n, limitkal), max) ;//더한값과 비교.
			return max;
		}
		if(depth == n) {
			return max;
		}
		arr.get(depth).visit = true;
		max =  Math.max(combs(arr, depth + 1, n, r - 1, limitkal, max), max);
		
		arr.get(depth).visit = false;
		max =  Math.max(combs(arr, depth+1, n, r, limitkal, max), max);
		return max;
	}

	private static int sumtaste(ArrayList<Food> arr, int n, int limitkal) {
		int sumtate = 0;
		int sumkal = 0;
		for(int i =0; i<n;i++) {
			if(arr.get(i).visit && sumkal + arr.get(i).kal <=limitkal) { //제한칼로리전까지 더함.
				sumtate += arr.get(i).taste; 
				sumkal += arr.get(i).kal; 
			}
		}
		return sumtate;
		
	}	

}
