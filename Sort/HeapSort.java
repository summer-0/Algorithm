package day09;

public class HeapSort {
/**
 * 堆排序:
 * 复杂度 nlogn  不是稳定排序
 *                   0（19）
 *         1（8）                                    2（27）
 *   3（6）                4（35）          5（14）    6（3）
 *7（12）  8（1）   9（0）
 *使大的数往上排（上层大与下层）
 *但左右子树大小无法比较
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
		buildMaxHeap(array);//建立最大堆
		for (int i = array.length - 1; i >= 1; i--) {
			//最大的在0位置，那么开始沉降，这样每交换一次最大的值就丢到最后了
			exchangeElements(array, 0, i);
			//继续获取0位置最大值
			maxHeap(array, i, 0);
		}
	}

	//(2)		//建立最大堆（只能使上一层大于下一层-->即parent>child  但不能区分左右子树的大小）
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
		int largest = index;  //先假设 parent是最大                                            
		if (left < heapSize && array[left] > array[index]) { //模拟完全二叉数                 
			largest = left;  //  左孩子大于 parent 把其下标记录为最大的值的下标
		}
		if (right < heapSize && array[right] > array[largest]) {
			largest = right;  //右孩子大， 把其下标记录为 最大的
		}
		if (index != largest) {  //说明  child（largest） 大于  parent，需要交换.大的要作为跟（parent）
			exchangeElements(array, index, largest);  //传入对应的下标即可，交换数据(模型是二叉树)

			maxHeap(array, heapSize, largest);  //迭代， 继续
		}
	}
	
//（3）		
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
