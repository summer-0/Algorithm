package day09;

import java.util.ArrayList;
import java.util.List;

public class BasicSort {
/**
 * ��������
 * 
 *  {9,1,3,5,26,124,0,7,11,22,34,21,111,136}
 *  ����λ�ű���
 *  {[0],[1,11,21,111],[22],[3],[124,34],[5],[26,136],[7],[],[9]}
 *  {0,1,11,21,111,22,3,124,34,5,26,136,7,9}
 *  ��ʮλ������
 *  {[0,1,3,5,7,9],[11,111],[21,22,124,26],[34,136]}
 *  {0,1,3,5,7,9,11,111,21,22,124,26,34,136}
 *  ����λ���ֱ���
 *  {[0,1,3,5,7,9,11,21,22,26,34],[111,124,136]}
 *  {0,1,3,5,7,9,11,21,22,26,34,111,124,136} --->�ź���
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
		int max = 0; //��ȡ���ֵ
		for(int i=0; i<array.length; i++){
			if(max < array[i]){
				max = array[i];  //����һ�飬�ó����ֵ
			}
		}
		int times = 0; //��ȡ���ֵλ��
		while(max > 0){
			max = max/10;  //ʮλ����λ...
			times++;  //��λ��
		}
		List<ArrayList> queue = new ArrayList<ArrayList>();//��ά����
		for(int i=0; i<10; i++){
			ArrayList q = new ArrayList<>();
			queue.add(q);
		}
		for(int i=0; i<times; i++){
			for(int j=0; j<array.length; j++){
				//��ȡ��Ӧ��λ��ֵ��iΪ0�Ǹ�λ��1��10λ��2�ǰ�λ��
				int x = array[j] % (int)Math.pow(10, i+1) / (int)Math.pow(10, i);  //Ħ��
				ArrayList q = queue.get(x);
				q.add(array[j]); //��Ԫ����ӽ���Ӧ�±�����
				//queue.set(x, q);
			}
			//��ʼ�ռ�
			int count = 0;
			for(int j=0; j<10; j++){
				while(queue.get(j).size() > 0){
					ArrayList<Integer> q = queue.get(j); //�õ�ÿһ������
					array[count] = q.get(0);
					q.remove(0);
					count++;
				}
			}
		}
	}
}
