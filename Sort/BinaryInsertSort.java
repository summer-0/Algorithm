package day09;

public class BinaryInsertSort {
/**
 * ���ַ��������� {9,3,2,6,10, 5} �����бȽ��ȶ���������ң�ʱ���ö��ַ�����ܺ�
 *  2      3    6    9   10   ����5
 * left        mid      right  ---->   mid>5 ȥ���ұߣ�����mid��
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
			int temp = array[i]; //���������
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
			//��ʼ���� ��left
			for(int j=i-1; j>=left; j--){
				//��left�ұߴ��ֵ������һλ���ȴ�temp����
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
