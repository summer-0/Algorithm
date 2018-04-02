package DTGH;

import java.util.Scanner;

/** 最大间隔
 * 给定一个递增序列，a1 <a2 <...<an 。定义这个序列的最大间隔为d=max{ai+1 - ai }(1≤i<n),现在要从a2 ,a3 ..an-1 中删除一个元素。
 * 问剩余序列的最大间隔最小是多少？
	输入描述:
	第一行，一个正整数n(1<=n<=100),序列长度;接下来n个小于1000的正整数，表示一个递增序列。
	输出描述:
	输出答案。
	示例1
	输入
	5
	1 2 3 7 8
	输出
	4
 * @author 49944
 *
 */
public class ZuiDaJianGe {

	private static int[] arrays;
	private static int n;
	private static int max = 0;

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arrays = new int[n];
        for(int i=0; i<n; i++){
        	arrays[i] = scan.nextInt();
        }
        System.out.println(getMax());
	}

	private static int getMax() {
		if(n <= 2){
			return -1;
		}
		int[] newArray = new int[n-1]; //保存初次的间隔大小
		for(int i=0; i<n-1; i++){
			newArray[i] = arrays[i+1] - arrays[i] - 1;
		}
		int[] secondArray = new int[n-2];
		for(int i=0; i<n-2; i++){
			secondArray[i] = newArray[i] + newArray[i+1] + 1;
			if(secondArray[i] > max){
				max = secondArray[i];
			}
		}
		
		return max;
	}
	

}
