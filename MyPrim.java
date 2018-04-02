package day06;

import java.util.ArrayList;
import java.util.List;


public class MyPrim {
/**
 * 普里姆算法 prim
 * 求最小生成树
 * 以一个顶点开始，找其的最小权值的边，收集相关顶点后，再找已有顶点的较小权值的边....
 * @param args
 */
	private static int INF = Integer.MAX_VALUE;
    private static char vertexs[];
	private static List<MEdge> list;
	public static void main(String[] args) {
		list = new ArrayList<>();
        list.add(new MEdge('A', 'B', 12));  // A --> B  权值：12（路径长度）
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
	 * 普里姆算法
	 */
	private  void myPrim() {
		int Vlen = vertexs.length;
		int min = 0, k=0; //min： 最小权值   k: 下标
		int sum = 0; //计算总的权值
		int[] shortlest = new int[Vlen]; //其实这里装的也是最短路径
		for(int i=0; i<Vlen; i++){
			shortlest[i] =  getWeight(0, i);// A 到 各点的权值()
		}
		for(int i=1; i<Vlen; i++){
			min = INF;
			//选取已有边中的最小边
			for(int j=0; j<Vlen; j++){
				if(shortlest[j] < min && shortlest[j] != 0){
					min = shortlest[j];
					k = j;
				}
			}
			sum = sum+min;
			//继续下一个点,找最小权值
			shortlest[k] = 0; //置为0的用意是，这条边拿过了(已经加入sum里)，下面的判断就会跳过这条边
			for(int j=0; j<Vlen; j++){
				if(shortlest[j]!=0 && getWeight(k, j)<shortlest[j]){
					shortlest[j] = getWeight(k, j); // getWeight(k, j)  顶点k（下标） 到其他顶点j(下标) 的权值
				}
			}
		}
		System.out.println("最小生成树权值和:"+sum);
		
	}


	private static class MEdge{
		private char start;
		private char end;
		private int weight;
		/**
		 * 边
		 * @param start 起点
		 * @param end 终点
		 * @param weight 权值
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
	 * 获取两个点之间的权值
	 * @param vs 起点(字母下标)
	 * @param des 终点(字母下标)
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
