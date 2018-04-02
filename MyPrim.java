package day06;

import java.util.ArrayList;
import java.util.List;


public class MyPrim {
/**
 * ����ķ�㷨 prim
 * ����С������
 * ��һ�����㿪ʼ���������СȨֵ�ıߣ��ռ���ض�����������ж���Ľ�СȨֵ�ı�....
 * @param args
 */
	private static int INF = Integer.MAX_VALUE;
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
        MyPrim myPrim = new MyPrim();
        myPrim.myPrim();
	}
	
	/**
	 * ����ķ�㷨
	 */
	private  void myPrim() {
		int Vlen = vertexs.length;
		int min = 0, k=0; //min�� ��СȨֵ   k: �±�
		int sum = 0; //�����ܵ�Ȩֵ
		int[] shortlest = new int[Vlen]; //��ʵ����װ��Ҳ�����·��
		for(int i=0; i<Vlen; i++){
			shortlest[i] =  getWeight(0, i);// A �� �����Ȩֵ()
		}
		for(int i=1; i<Vlen; i++){
			min = INF;
			//ѡȡ���б��е���С��
			for(int j=0; j<Vlen; j++){
				if(shortlest[j] < min && shortlest[j] != 0){
					min = shortlest[j];
					k = j;
				}
			}
			sum = sum+min;
			//������һ����,����СȨֵ
			shortlest[k] = 0; //��Ϊ0�������ǣ��������ù���(�Ѿ�����sum��)��������жϾͻ�����������
			for(int j=0; j<Vlen; j++){
				if(shortlest[j]!=0 && getWeight(k, j)<shortlest[j]){
					shortlest[j] = getWeight(k, j); // getWeight(k, j)  ����k���±꣩ ����������j(�±�) ��Ȩֵ
				}
			}
		}
		System.out.println("��С������Ȩֵ��:"+sum);
		
	}


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
		public char getStart() {
			return start;
		}
		public void setStart(char start) {
			this.start = start;
		}
		public char getEnd() {
			return end;
		}
		public void setEnd(char end) {
			this.end = end;
		}
		public int getWeight(char start1, char end1) {
			if(this.start == start1 && this.end == end1){
				return weight;
			}else if(this.start == end1 && this.end == start1){
				return weight;
			}else{
				return INF;
			}
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		
	}
	/**
	 * ��ȡ������֮���Ȩֵ
	 * @param vs ���(��ĸ�±�)
	 * @param des �յ�(��ĸ�±�)
	 * @return
	 */
	private int getWeight(int vs, int des) {
		char start = vertexs[vs];
		char end = vertexs[des];
		int weight = INF;
		if(start == end){
			return 0;
		}
		for(int i=0; i<list.size(); i++){
			char start2 = list.get(i).getStart();
			char end2 = list.get(i).getEnd();
			
			if((start==start2 && end==end2) || (start==end2 && end==start2) ){
				weight = list.get(i).getWeight(start, end);
			}
		}
		return weight;
	}
}
