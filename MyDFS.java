package day06;

import java.util.ArrayList;
import java.util.List;


public class MyDFS {
/**
 * ������ȱ�����
 * @param args
 */
	
	private static class MEdge{
		private char start;
		private char end;
		private int weight;
		/**
		 * ��
		 * @param start ���
		 * @param end �յ�
		 * @param weight Ȩֵ
		 */
		public MEdge(char start, char end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	//��Ҫ�õ�����
	public void myDFS(List<MEdge> list){
		int Vlen = vertexs.length;
		boolean[] isVisted = new boolean[Vlen]; //Ĭ����false ����Ҫ��ʼ��
		System.out.println("DFS:");
		for(int i=0; i<Vlen; i++){
			if(dfs(vertexs[i], isVisted[i])){
				isVisted[i] = true;
			};
			for(int j=0; j<Vlen; j++){
				if(vertexs[i] == list.get(j).start){
					dfs(list.get(j).end, isVisted[i]);
					break;
				}
			}
			
		}
		
	}
	public boolean dfs(char start, boolean isVisted){
		if(!isVisted){
			System.out.print(start+" ");
			return true;
		}else{
			return false;
		}
	}
	
	private static char vertexs[];
	private static List<MEdge> list;
	
	public static void main(String[] args) {
		list = new ArrayList<>();
        list.add(new MEdge('A', 'B', 12));  // A --> B  Ȩֵ��12��·�����ȣ�
        list.add(new MEdge('A', 'F', 16));
        list.add(new MEdge('A', 'G', 14));
        list.add(new MEdge('B', 'C', 10));
        list.add(new MEdge('B', 'F',  7));
        list.add(new MEdge('C', 'D',  3));
        list.add(new MEdge('C', 'E',  5));
        list.add(new MEdge('C', 'F',  6));
        list.add(new MEdge('D', 'E',  4));
        list.add(new MEdge('E', 'F',  2));
        list.add(new MEdge('E', 'G',  8));
        list.add(new MEdge('F', 'G',  9));
        vertexs = new char[]{'A','B','C','D','E','F','G'}; 
	}

}
