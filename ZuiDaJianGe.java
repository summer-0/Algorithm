package DTGH;

import java.util.Scanner;

/** �����
 * ����һ���������У�a1 <a2 <...<an ������������е������Ϊd=max{ai+1 - ai }(1��i<n),����Ҫ��a2 ,a3 ..an-1 ��ɾ��һ��Ԫ�ء�
 * ��ʣ�����е��������С�Ƕ��٣�
	��������:
	��һ�У�һ��������n(1<=n<=100),���г���;������n��С��1000������������ʾһ���������С�
	�������:
	����𰸡�
	ʾ��1
	����
	5
	1 2 3 7 8
	���
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
		int[] newArray = new int[n-1]; //������εļ����С
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
