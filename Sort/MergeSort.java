package day09;

public class MergeSort {
/**
 * 归并排序:(最不耗内存) nlogn 稳定排序
 * {19, 8, 27, 6, 35, 14, 3, 12, 1, 0, 9, 10}
 * 分二部分排序
 * {19, 8, 27, 6, 35, 14}  继续迭代排序（分二部分排序）
 * {3, 12, 1, 0, 9, 10}
 * @param args
 */
	public static void main(String[] args) {
       MergeSort mergeSort = new MergeSort();
       int[] array = new int[]{19, 8, 27, 6, 35, 14, 3, 12, 1, 0, 9, 10, 7};
       mergeSort.mergeSort(array, 0, array.length-1);
       for (int i : array) {
		   System.out.println(i);
	   }
	}
	public void mergeSort(int[] array, int left, int right){
		if(left < right){
			int middle = (left + right)/2;
			mergeSort(array, left, middle);
			mergeSort(array, middle+1, right);
			merge(array, left, middle, right); //合并
		}
	}
	/**
	 * 合并
	 * @param array
	 * @param left
	 * @param middle
	 * @param right
	 */
	private void merge(int[] array, int left, int middle, int right) {
		int[] tempArray = new int[array.length];
		int rightStart = middle + 1;
		int temp = left;
		int third = left;
		//比较两个小数组相应下标位置的数组大小，小的先放进数组
		while(left<=middle && rightStart<= right){
			if(array[left] <= array[rightStart]){
				tempArray[third++] = array[left++];
			}else{
				tempArray[third++] = array[rightStart++];
			}
		}
		//如果左边还有数据需要拷贝，把左边数组剩下的拷贝到新数组
		while(left <= middle){
			tempArray[third++] = array[left++];
		}
		//如果右边还有数据...
		while(rightStart <= right){
			tempArray[third++] = array[rightStart++];
		}
		while(temp <= right){
			array[temp] = tempArray[temp];
			temp++;
		}
	}

}
