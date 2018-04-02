package day09;

public class HeerSort {
/**
 * ϣ���������ڶ��ַ����������ֱ�Ӳ�������
 * ���ȶ�����,��������Խ��Խ����׼
 * ���磺
 * {9,3,2,6,10,5,44,83,28}
 * ����d = length/3 = 3;
 * 9 6  44  -->  6 9 44 �ֲ�ð������
 * 3 10 83  --> 3 10 83 
 * 2 5  28  --> 2 5 28
 * --->>>
 * 6 3 2 9 10 5 44 83 28 
 * 
 * ���� d = 2
 * 6 2 10 44 28 --> 2 6 10 28 44
 * 3 9 5 83     --> 3 5 9  83
 * --->>>
 * 2 3 6 5 10 9 28 83 44
 * ....
 * 
 * @param args
 */
	public static void main(String[] args) {
		
		int[] array = {9,3,2,6,10,5,44,83,28,5,1,0,36,22,11,-8,19,80,46,17,7,-1}; //0~19
		int d = array.length/2; //����  10
		while(true){
			for(int i=0; i<d; i++){
				
				for(int j=i; j+d<array.length; j = j+d){  //�ֲ�ð������
					for(int n=j; n+d<array.length; n = n+d){
						int temp;
						if(array[n] > array[n+d]){  //��С������
							temp = array[n];      //���˹۵㣺�ֲ�ð������
							array[n] = array[n+d];
							array[n+d] = temp;
						}
					}
				}
			}
			if(d == 1){
				break;
			}
			d--;
		}
		for (int i : array) {
			System.out.println(i);
		}
	}

}
