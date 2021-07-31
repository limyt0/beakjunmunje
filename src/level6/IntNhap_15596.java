package level6;

import java.io.*;
import java.util.StringTokenizer;

class Test{
	long sum(int[] a) { 
		long ans=0;
		for(int i = 0; i<a.length; i++) {
			ans += a[i];
		}
		
		
		return ans;
	}
}
/*public class IntNhap_15596 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[] a = new int[N]; 
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a[i] = i+1;
		}
		Test t = new Test();
		System.out.println(t.sum(a));
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
}
*/