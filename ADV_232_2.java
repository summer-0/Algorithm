package javaB;

import java.util.Scanner;

/**
 * 矩阵乘法:
 * 问题描述
　　有n个矩阵，大小分别为a0*a1, a1*a2, a2*a3, ..., a[n-1]*a[n]，现要将它们依次相乘，只能使用结合率，求最少需要多少次运算。
　　两个大小分别为p*q和q*r的矩阵相乘时的运算次数计为p*q*r。
	输入格式
	　　输入的第一行包含一个整数n，表示矩阵的个数。
	　　第二行包含n+1个数，表示给定的矩阵。
	输出格式
	　　输出一个整数，表示最少的运算次数。
	样例输入
	3
	1 10 5 20
	样例输出
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
