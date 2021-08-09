package study.a0803To0805;

import java.io.*;
import java.util.Stack;

public class BJ9012_괄호 {
	//
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			String result = stack_result(br.readLine());
			bw.write(result+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	static String stack_result(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '(') {
				stack.push(c);
			}else if(stack.empty()) {
				return "NO";// pop 불가능할 경우 볼필요 없이 바로 NO.
			}else if(c == ')'){
				stack.pop();
			}
		}
		
		if(stack.empty()) {
			return "YES";//딱 맞게 pop되어서 empty가 됨.
		}else {
			return "NO";
		}
	}
}
