package day06;

import java.util.ArrayList;
import java.util.List;

public class MyDijikstra {
/**
 * �Ͻ�˹����  Dijkstra
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
        MyDijikstra myDijikstra = new MyDijikstra();
        myDijikstra.myDijikstra(6, list, vertexs);
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
	 * �Ͻ�˹����
	 * @param vs ������(�������������̾���)
	 * @param list 
	 * @param vertex
	 */
	public void myDijikstra(int vs, List<MEdge> list, char[] vertex){
		int Vlen = vertex.length;
		boolean isVisted[] = new boolean[Vlen]; //�Ƿ���ʹ�
		int[] shortest = new int[Vlen]; //���ڴ��vs�������������̵�·�������ȣ� 
		
		//��һ����vs�����������Ȩֵ .. �������ֱ�������ģ��͸�ֵ INF�������shortest[]������
		for(int i=0; i<Vlen; i++){
			isVisted[i] = false;
			shortest[i] = getWeight(vs, i); //�õ�������֮���Ȩֵ
		}
		isVisted[vs] = true; //�����㿪ʼ
		shortest[vs] = 0;
		
		//�ڶ�����������Vlen-1���Σ��ҵ���vs��������һ����Ȩֵ��С���㣬Ȼ�����shortest[]����СȨֵ��·�����ȣ�  ÿ���ҳ�һ����������·����
		int k=0;
		for(int i=1; i<Vlen; i++){
			//Ϊ��ȡ���·���Ķ����У��ҵ���vs����Ķ���k
			int min = INF;
			for(int j=0; j<Vlen; j++){
				if( isVisted[j]==false && shortest[j] < min){
					min = shortest[j];
					k = j;
				}
			}
			//Ȼ�� �±�Ϊ k �ĵ�Ҫ��������
			isVisted[k] = true;
			//��ʱ�������·��  ���㣨k��������ľ��� 
			for(int j=0; j<Vlen; j++){
				int temp = getWeight(k, j);  //�õ�k�㵽������ľ���
				temp = (temp==INF ? INF :(min+temp));// ��ֹ���
			       //tmp = (tmp==INF ? INF : (min + tmp)); // ��ֹ���
				if(temp < shortest[j] && isVisted[j] == false){
					shortest[j] = temp ;
				}
			}

		}
		//��ӡ���·��
		System.out.println("dijkstra:"+vertexs[vs]);
		for(int i=0; i<Vlen; i++){
			System.out.printf("  shortest(%c, %c): %d\n", vertex[vs], vertex[i], shortest[i]);
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
