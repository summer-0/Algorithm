package day09;

public class SelectSort {
/**
 * ѡ������
 *  {9,3,4,5,2,6,0,11}
 * 0 {9,3,4,5,2,6,11}
 * 0,2 {9,3,4,5,6,11}
 * 0,2,3 {9,4,5,6,11}
 * ....
 * 
 * ���Ӷȣ� n +(n-1)+(n-2)++++ 1   =  (n+1)*n/2  --->  n^2  ������ð������  (Ч�ʸ�һ��)
 * ð�������Ӷȣ�n^2  
 * @param args
 */
	public static void main(String[] args) {
        int[] array = new int[]{9,3,4,5,2,6,0,2,11};
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(array);
	}

	public void selectSort(int[] array){	
		int min , temp ;
		for(int i=0; i<array.length; i++){
			min = array[i];  //
			for(int j=i+1; j<array.length; j++){
				if(array[j] < min){
					min = array[j];
					temp = array[i];
					array[i] = min;
					array[j] = temp;
					 
				}
			}
			
		}
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
