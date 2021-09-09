package study.kakao;

import java.util.Stack;

public class kakao2018_다트게임 {

	public static void main(String[] args) {
		int answer = 0;
		String dartResult = "1D2S#10S";
		Stack<Integer> stack = new Stack<>();
		int be_num = -1;//이전 값 -1로 초기화
		int num = -1; //현재 값.
		for(int i = 0; i<dartResult.length(); i++) {
			char ch = dartResult.charAt(i);
			switch(ch) {
			case 'S': //1제곱이라 아무것도 안 해도 되지만 default에 걸리지 않도록
				break;
			case 'D':
				num = stack.peek();
				stack.pop();
				stack.push(num*num);
				break;
			case 'T':
				num = stack.peek();
				stack.pop();
				stack.push(num*num*num);
				break;
			case '*':
				if(i == 2) { //처음 등장시만. 이전값이 없으므로
					num = stack.peek();
					stack.pop();
					stack.push(num*2);
				}else {
					num = stack.peek(); //현재 값.
					stack.pop();
					be_num = stack.peek(); //이전 값.
					stack.pop();
					stack.push(be_num*2);
					stack.push(num*2);
				}
				break;
			case '#':
				num = stack.peek();
				stack.pop();
				stack.push(num*(-1));
				break;
			default: //숫자
				if(i != 0  && dartResult.charAt(i-1) == '1' && dartResult.charAt(i) =='0') {
					//1과 0이 연속으로 나오면
					stack.pop();//이전 1로 저장된 스택을 지움.
					stack.push(10);//스택에 10 넣음.
				}else {
					stack.push(ch-48);
				}				
				break;
			}
		}
		while(stack.size() !=0) {
			System.out.println(stack.peek());
			answer += stack.pop();
		}
		
		//return answer;
		System.out.println(answer);
	}

}
