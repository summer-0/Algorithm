package day09;

public class BinaryInsertSort {
/**
 * 二分法插入排序： {9,3,2,6,10, 5} 当序列比较稳定（不会很乱）时，用二分法排序很好
 *  2      3    6    9   10   插入5
 * left        mid      right  ---->   mid>5 去掉右边（包括mid）
 * 2            3  
 * left(mid)    right  ....
 * @param args
 */
	public static void main(String[] args) {
        BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
        int[] array = {9,3,2,6,10,5,44,83,28,5,1,0,36};
        binaryInsertSort.sort(array);
	}
	public void sort(int[] array){
		for(int i=1; i<array.length; i++){
			int temp = array[i]; //待插入的数
			int left = 0;
			int right = i-1;
			int mid = 0;
			while(left <= right){
				mid = (left + right)/2;
				if(temp < array[mid]){
					right = mid -1;
     			}else{
     				left = mid +1; 
     			}
			}
			//开始插入 到left
			for(int j=i-1; j>=left; j--){
				//比left右边大的值往后移一位，等带temp插入
				array[j+1] = array[j];
			}
			if(left != i){
				array[left] = temp; 
			}
		}
		
		for (int i : array) {
			System.out.println(i);
		}
	}

}
