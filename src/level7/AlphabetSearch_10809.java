package level7;

import java.io.*;
import java.util.StringTokenizer;

public class AlphabetSearch_10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String st;
		st = br.readLine();
		
		int [] arr = new int[26];
		for(int i = 0; i< 26; i++) {
			arr[i] = -1;
		}
		
		char[] cs;
		for(int i = st.length()-1; i>=0; i--) {
			int N = atoint(st.charAt(i));
			arr[N] = i;
		}
		for(int i = 0; i<26 ; i++) {
			bw.write(arr[i]+" ");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	static int atoint(char c) {
		int i;
		i = c-97;
		return i;
	}
}
