package day09;

public class QuickSort {
/**
 * �������� >=nlogn �����ȶ�����
 *  19, 8, 27, 6, 35, 14, 3, 12, 1, 0, 9, 10, 7
 *  low(19����)                                  high
 *  19>8--->                                  19>7    --->low��high����
 *    
 * @param args
 */
	public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[]{19, 8, 27, 6, 35, 14, 3, 12, 1, 0, 9, 10, 7};
        quickSort.quick(array);
        for (int i : array) {
			System.out.println(i);
		}
	}
    public void quick(int[] array){
    	if(array.length > 0){
    		quickSort(array, 0, array.length-1);
    	}
    }
    /**
     * 
     * @param array
     * @param low
     * @param high
     */
	private void quickSort(int[] array, int low, int high) {
        if(low < high){
        	int middle = getMiddle(array, low, high);
        	//����
        	quickSort(array, 0, middle-1); //����ⲿ��
        	quickSort(array, middle+1, high); //�ұ��ⲿ��
        }		
	}
	/**
	 * ��ȡ�м��±�
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	private int getMiddle(int[] array, int low, int high) {
		int temp = array[low];//��׼Ԫ��
		while(low < high){
			while(low<high && array[high] >= temp){
				high--;
			}
			array[low] = array[high];
			while(low < high && array[low] <= temp){
				low++;
			}
			array[high] = array[low];
		}
		array[low] = temp;  //�嵽�������ȷ��λ�� 
		return low;
	}
}
