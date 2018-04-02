package day09;

public class HeerSort {
/**
 * 希尔排序：优于二分法插入排序和直接插入排序
 * 不稳定排序,增量调的越大，越不精准
 * 例如：
 * {9,3,2,6,10,5,44,83,28}
 * 增量d = length/3 = 3;
 * 9 6  44  -->  6 9 44 局部冒泡排序
 * 3 10 83  --> 3 10 83 
 * 2 5  28  --> 2 5 28
 * --->>>
 * 6 3 2 9 10 5 44 83 28 
 * 
 * 增量 d = 2
 * 6 2 10 44 28 --> 2 6 10 28 44
 * 3 9 5 83     --> 3 5 9  83
 * --->>>
 * 2 3 6 5 10 9 28 83 44
 * ....
 * 
 * @param args
 */
	public static void main(String[] args) {
		
		int[] array = {9,3,2,6,10,5,44,83,28,5,1,0,36,22,11,-8,19,80,46,17,7,-1}; //0~19
		int d = array.length/2; //增量  10
		while(true){
			for(int i=0; i<d; i++){
				
				for(int j=i; j+d<array.length; j = j+d){  //局部冒泡排序
					for(int n=j; n+d<array.length; n = n+d){
						int temp;
						if(array[n] > array[n+d]){  //从小到大排
							temp = array[n];      //个人观点：局部冒泡排序
							array[n] = array[n+d];
							array[n+d] = temp;
						}
					}
				}
			}
			if(d == 1){
				break;
			}
			d--;
		}
		for (int i : array) {
			System.out.println(i);
		}
	}

}
