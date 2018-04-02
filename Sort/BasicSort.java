package day09;

import java.util.ArrayList;
import java.util.List;

public class BasicSort {
/**
 * 基数排序
 * 
 *  {9,1,3,5,26,124,0,7,11,22,34,21,111,136}
 *  按个位排遍历
 *  {[0],[1,11,21,111],[22],[3],[124,34],[5],[26,136],[7],[],[9]}
 *  {0,1,11,21,111,22,3,124,34,5,26,136,7,9}
 *  按十位数遍历
 *  {[0,1,3,5,7,9],[11,111],[21,22,124,26],[34,136]}
 *  {0,1,3,5,7,9,11,111,21,22,124,26,34,136}
 *  按百位数字遍历
 *  {[0,1,3,5,7,9,11,21,22,26,34],[111,124,136]}
 *  {0,1,3,5,7,9,11,21,22,26,34,111,124,136} --->排好了
 * @param args
 */
	public static void main(String[] args) {
        BasicSort basicSort = new BasicSort();
        int[] array = {9,1,3,5,26,124,0,7,11,22,34,21,111,136};
        basicSort.sort(array);
        for (int i : array) {
			System.out.println(i);
		}
	}
	public void sort(int[] array){
		int max = 0; //获取最大值
		for(int i=0; i<array.length; i++){
			if(max < array[i]){
				max = array[i];  //遍历一遍，得出最大值
			}
		}
		int times = 0; //获取最大值位数
		while(max > 0){
			max = max/10;  //十位，百位...
			times++;  //求位数
		}
		List<ArrayList> queue = new ArrayList<ArrayList>();//多维数组
		for(int i=0; i<10; i++){
			ArrayList q = new ArrayList<>();
			queue.add(q);
		}
		for(int i=0; i<times; i++){
			for(int j=0; j<array.length; j++){
				//获取对应的位的值（i为0是个位，1是10位，2是百位）
				int x = array[j] % (int)Math.pow(10, i+1) / (int)Math.pow(10, i);  //摩尔
				ArrayList q = queue.get(x);
				q.add(array[j]); //把元素添加进对应下标数组
				//queue.set(x, q);
			}
			//开始收集
			int count = 0;
			for(int j=0; j<10; j++){
				while(queue.get(j).size() > 0){
					ArrayList<Integer> q = queue.get(j); //拿到每一个数组
					array[count] = q.get(0);
					q.remove(0);
					count++;
				}
			}
		}
	}
}
