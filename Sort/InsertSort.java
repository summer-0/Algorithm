package day09;

public class InsertSort {
/**
 * ֱ�Ӳ������򣺱߱���������    (�ռ临�ӶȽϴ��ڴ����Ƶ��)
 * {9,3,2,6,10,44,83,28,5,1,0,36}
 * 9
 * 3,9
 * 2,3,9
 * 2,3,6,9
 * 2,3,6,9,10
 * .....
 * 
 * @param args
 */
	public static void main(String[] args) {
        int[] array = {9,3,2,6,10,44,83,28,5,1,0,36};
        
        for(int i=1; i<array.length; i++){
        	int temp = array[i];
        	int j;
        	for(j=i-1; j>=0; j--){
        		if(array[j] > temp){
        		   array[j+1] = array[j];	 //�Ӻ��濪ʼһ��һ������Ų(��ǰ�濪ʼ�ȽϺ�)
        		}else{
        			break;
        		}
        	}
        	array[j+1] = temp;//  �����j+1 ����Ϊ  ����j-- ѭ�����������˳���
        }
        
        System.out.println("�����");
        for (int i : array) {
			System.out.print(i+" ");
		}
       
	}

}
