package javaB;

import java.util.Scanner;

/**
 * ����˷�:
 * ��������
������n�����󣬴�С�ֱ�Ϊa0*a1, a1*a2, a2*a3, ..., a[n-1]*a[n]����Ҫ������������ˣ�ֻ��ʹ�ý���ʣ���������Ҫ���ٴ����㡣
����������С�ֱ�Ϊp*q��q*r�ľ������ʱ�����������Ϊp*q*r��
	�����ʽ
	��������ĵ�һ�а���һ������n����ʾ����ĸ�����
	�����ڶ��а���n+1��������ʾ�����ľ���
	�����ʽ
	�������һ����������ʾ���ٵ����������
	��������
	3
	1 10 5 20
	�������
	150
 * 
 * @author 49944
 *
 */
public class ADV_232_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
        int arrays[] = new int[n+1];
        for(int i=0; i<n+1; i++ ){
        	arrays[i] = scan.nextInt();
        }
        
        int recurMatrixChain = RecurMatrixChain(1, arrays.length-1, arrays);
        System.out.println(recurMatrixChain);
	}
/**
 * 
 * @param i
 * @param j
 * @param arrays
 */
	private static int RecurMatrixChain(int i, int j, int[] arrays) {
		if(i == j){
			return 0;
		}
		int u = RecurMatrixChain(i, i, arrays) + RecurMatrixChain(i+1, j, arrays) + arrays[i-1]*arrays[i]*arrays[j];
		int len = arrays.length;
		for(int k=i+1; k<j; k++){
			int t = RecurMatrixChain(i, k, arrays) + RecurMatrixChain(k+1, j, arrays) + arrays[i-1]*arrays[k]*arrays[j];
			if(t < u){
				u = t;
			}
		}
		return u;
		
	}

}
