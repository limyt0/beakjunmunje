package level10;

import java.io.*;

//public class BJ2447별찍기 {
//
//	static char[][] arr;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		arr = new char[N][N];
//		
//		stars(0, 0, N, false);
//		
//		StringBuilder sb= new StringBuilder();
//		for(int i =0; i<N;i++) {
//			for(int j =0; j<N;j++) {
//				sb.append(arr[i][j]);
//			}
//			sb.append('\n');
//		}
//		System.out.println(sb);
//		br.close();
//	}
//
//	private static void stars(int x, int y, int n, boolean b) {
//		//공백칸일 경우
//		if(b) {
//			for(int i =x; i<x+n;i++) {
//				for(int j = y; j<y+n;j++) {
//					arr[i][j] = ' ';
//				}
//			}
//			return;
//		}
//		
//		//더이상 쪼갤 수 없는 블록일 때.
//		if(n == 1) {
//			arr[x][y] = '*';
//			return;
//		}
//		
//		int size =n/3;
//		int count = 0;
//		for(int i = x; i<x+n; i+=size) {
//			for(int j = y; j<y+n; j+=size) {
//				count++;
//				if(count == 5) {
//					stars(i,j,size,true);
//				}else {
//					stars(i,j,size,false);
//				}
//			}
//		}
//		
//	}
//
//	
//	
//	
//}


public class BJ2447별찍기 {

	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		br.close();
	}

	private static void stars(int x, int y, int n, boolean b) {
	}	

	

	
}
