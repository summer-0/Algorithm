package day09;

public class HeapSort {
/**
 * ������:
 * ���Ӷ� nlogn  �����ȶ�����
 *                   0��19��
 *         1��8��                                    2��27��
 *   3��6��                4��35��          5��14��    6��3��
 *7��12��  8��1��   9��0��
 *ʹ����������ţ��ϲ�����²㣩
 *������������С�޷��Ƚ�
 *         
 * 
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapSort heapSort = new HeapSort();
		int[] array = { 19, 8, 27, 6, 35, 14, 3, 12, 1, 0, 9, 10, 7 };

		System.out.println("Before heap:");
		heapSort.printArray(array);

		heapSort.heapSort(array);

		System.out.println("After heap sort:");
		heapSort.printArray(array);
	}
	public void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		buildMaxHeap(array);//��������
		for (int i = array.length - 1; i >= 1; i--) {
			//������0λ�ã���ô��ʼ����������ÿ����һ������ֵ�Ͷ��������
			exchangeElements(array, 0, i);
			//������ȡ0λ�����ֵ
			maxHeap(array, i, 0);
		}
	}

	//(2)		//�������ѣ�ֻ��ʹ��һ�������һ��-->��parent>child  �������������������Ĵ�С��
	private void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int half = (array.length-1) / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}

	private void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;  //�ȼ��� parent�����                                            
		if (left < heapSize && array[left] > array[index]) { //ģ����ȫ������                 
			largest = left;  //  ���Ӵ��� parent �����±��¼Ϊ����ֵ���±�
		}
		if (right < heapSize && array[right] > array[largest]) {
			largest = right;  //�Һ��Ӵ� �����±��¼Ϊ ����
		}
		if (index != largest) {  //˵��  child��largest�� ����  parent����Ҫ����.���Ҫ��Ϊ����parent��
			exchangeElements(array, index, largest);  //�����Ӧ���±꼴�ɣ���������(ģ���Ƕ�����)

			maxHeap(array, heapSize, largest);  //������ ����
		}
	}
	
//��3��		
	public void printArray(int[] array) {  
        System.out.print("{");  
        for (int i = 0; i < array.length; i++) {  
            System.out.print(array[i]);  
            if (i < array.length - 1) {  
                System.out.print(", ");  
            }  
        }  
        System.out.println("}");  
    }  
	
	
	public void exchangeElements(int[] array, int index1, int index2) {  
        int temp = array[index1];  
        array[index1] = array[index2];  
        array[index2] = temp;  
    }  
}
