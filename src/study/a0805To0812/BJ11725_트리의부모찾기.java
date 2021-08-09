package study.a0805To0812;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
	private Node parents;//부모 노드.
	private int value;
	public Node(Node parents, int value) {
		//super();
		this.parents = parents;
		this.value = value;
	}
	
}

public class BJ11725_트리의부모찾기 {

	public static void main(String[] args) throws IOException {
		ArrayList<Node> node = new ArrayList<>(); 
		Node root = new Node(null,1);//루트 노드
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
	}

}
