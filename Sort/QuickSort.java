package day09;

public class QuickSort {
/**
 * 快速排序： >=nlogn 不是稳定排序
 *  19, 8, 27, 6, 35, 14, 3, 12, 1, 0, 9, 10, 7
 *  low(19基数)                                  high
 *  19>8--->                                  19>7    --->low与high交换
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
        	//迭代
        	quickSort(array, 0, middle-1); //左边这部分
        	quickSort(array, middle+1, high); //右边这部分
        }		
	}
	/**
	 * 获取中间下标
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	private int getMiddle(int[] array, int low, int high) {
		int temp = array[low];//基准元素
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
		array[low] = temp;  //插到排序后正确的位置 
		return low;
	}
}
