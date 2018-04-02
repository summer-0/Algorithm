package day09;

public class MergeSort {
/**
 * �鲢����:(����ڴ�) nlogn �ȶ�����
 * {19, 8, 27, 6, 35, 14, 3, 12, 1, 0, 9, 10}
 * �ֶ���������
 * {19, 8, 27, 6, 35, 14}  �����������򣨷ֶ���������
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
			merge(array, left, middle, right); //�ϲ�
		}
	}
	/**
	 * �ϲ�
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
		//�Ƚ�����С������Ӧ�±�λ�õ������С��С���ȷŽ�����
		while(left<=middle && rightStart<= right){
			if(array[left] <= array[rightStart]){
				tempArray[third++] = array[left++];
			}else{
				tempArray[third++] = array[rightStart++];
			}
		}
		//�����߻���������Ҫ���������������ʣ�µĿ�����������
		while(left <= middle){
			tempArray[third++] = array[left++];
		}
		//����ұ߻�������...
		while(rightStart <= right){
			tempArray[third++] = array[rightStart++];
		}
		while(temp <= right){
			array[temp] = tempArray[temp];
			temp++;
		}
	}

}
