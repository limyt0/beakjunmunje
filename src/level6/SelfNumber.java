package level6;

public class SelfNumber {

	public static void main(String[] args) {
		int[] n = new int[10001];
		for(int i =0; i <n.length;i++) {
			int dn=i;
			int nt = i;
			while(nt >0) {
				dn += nt%10;
				nt /= 10;
			}			
			if(dn <= 10000) {
				n[dn] += 1;
			}
			
		}
		for(int i= 1; i<n.length;i++) {
			if(n[i] ==0) {
				System.out.println(i);
			}
		}		
	}
}
