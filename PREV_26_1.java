/**
 * ��������
��������һ��n*m�ľ���A����A�е�һ���ǿ��Ӿ���ʹ����Ӿ����е�Ԫ�غ����
�������У�A���Ӿ���ָ��A���к��о�������һ�顣
	�����ʽ
	��������ĵ�һ�а�����������n, m���ֱ��ʾ����A��������������
	����������n�У�ÿ��m����������ʾ����A��
	�����ʽ
	�������һ�У�����һ����������ʾA�������Ӿ����е�Ԫ�غ͡�
	��������
	3 3
	-1 -4 3
	3 4 -1
	-5 -2 8
	�������
	10
	����˵��
	����ȡ���һ�У���Ϊ10��
 */
import java.util.Scanner;

public class PREV_26_1 {
	public static int n, m;
	public static long[][] map;
	public static long result = Long.MIN_VALUE;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new long[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				map[i][j] = in.nextLong();
		for (int start = 0; start < n; start++) { // ��ʼ��
			long[] ring = new long[m];
			long[] dp = new long[m];
			for (int end = start; end < n; end++) { // ������
				for (int j = 0; j < m; j++) // ����start~end�е�ÿһ��Ԫ�غ�
					ring[j] += map[end][j];
				
				result = Math.max(result, ring[0]);
				
				dp[0] = ring[0];
				for (int j = 1; j < m; j++) {
					if (dp[j - 1] < 0)
						dp[j] = ring[j];
					else
						dp[j] = dp[j - 1] + ring[j];
					result = Math.max(result, dp[j]);
				}
			}
		}
		System.out.println(result);
	}
}