package study.kakao;

public class kakao2018비밀지도 {

	public static void main(String[] args) {
		String[] answer = {};
		int input[] = {9,20,28,18,11};
		char[][] result = new char[5][5];
			for(int i =0;i<5;i++) {
				int tmp = input[i];
				
				 for(int j =4; j>=0; j--) {
					 if(tmp % 2 == 0) {
						 result[i][j] = ' ';
					 }else if(tmp % 2 == 1) {
						 result[i][j] = '#';
					 }
					 tmp = tmp/2;
				 }
			}
		 
		  
			for(int i=0;i<5;i++) {
				for(int j = 0; j<5; j++) {
					System.out.print(result[i][j]);  
				}
				System.out.println("");
			}
		  

	}
}
