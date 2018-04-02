package day06;

import java.util.ArrayList;
import java.util.List;

public class MyDijikstra {
/**
 * 迪杰斯特拉  Dijkstra
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
        MyDijikstra myDijikstra = new MyDijikstra();
        myDijikstra.myDijikstra(6, list, vertexs);
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
	 * 迪杰斯特拉
	 * @param vs 出发点(到各个顶点的最短距离)
	 * @param list 
	 * @param vertex
	 */
	public void myDijikstra(int vs, List<MEdge> list, char[] vertex){
		int Vlen = vertex.length;
		boolean isVisted[] = new boolean[Vlen]; //是否访问过
		int[] shortest = new int[Vlen]; //用于存放vs到各个顶点的最短的路径（长度） 
		
		//第一步，vs到各个顶点的权值 .. 如果不能直接相连的，就赋值 INF，存放在shortest[]数组中
		for(int i=0; i<Vlen; i++){
			isVisted[i] = false;
			shortest[i] = getWeight(vs, i); //得到两个点之间的权值
		}
		isVisted[vs] = true; //出发点开始
		shortest[vs] = 0;
		
		//第二步，遍历（Vlen-1）次，找到与vs相连的下一个（权值最小）点，然后更新shortest[]的最小权值（路径长度）  每次找出一个顶点的最短路径。
		int k=0;
		for(int i=1; i<Vlen; i++){
			//为获取最短路径的顶点中，找到离vs最近的顶点k
			int min = INF;
			for(int j=0; j<Vlen; j++){
				if( isVisted[j]==false && shortest[j] < min){
					min = shortest[j];
					k = j;
				}
			}
			//然后 下标为 k 的点要被访问了
			isVisted[k] = true;
			//此时修正最短路径  顶点（k）到各点的距离 
			for(int j=0; j<Vlen; j++){
				int temp = getWeight(k, j);  //得到k点到各个点的距离
				temp = (temp==INF ? INF :(min+temp));// 防止溢出
			       //tmp = (tmp==INF ? INF : (min + tmp)); // 防止溢出
				if(temp < shortest[j] && isVisted[j] == false){
					shortest[j] = temp ;
				}
			}

		}
		//打印最短路径
		System.out.println("dijkstra:"+vertexs[vs]);
		for(int i=0; i<Vlen; i++){
			System.out.printf("  shortest(%c, %c): %d\n", vertex[vs], vertex[i], shortest[i]);
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
