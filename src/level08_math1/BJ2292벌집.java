package level08_math1;

import java.io.*;


public class BJ2292벌집 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = -1;
		int i = 0;
		if( N== 1) {
			result = 1;
		}else {
			while(true) {
				i++;
				//result++;
				int x1 = 3*(i*i-i)+2;
				int x2 = 3*(i*i+i)+1;
				if(x1<= N && x2 >= N) {
					result = i+1;
					break;
				}
			}
		}
		System.out.println(result); 
		br.close();
	}
}
