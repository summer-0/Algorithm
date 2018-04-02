/**
 * 问题描述
　　给定一个n*m的矩阵A，求A中的一个非空子矩阵，使这个子矩阵中的元素和最大。
　　其中，A的子矩阵指在A中行和列均连续的一块。
	输入格式
	　　输入的第一行包含两个整数n, m，分别表示矩阵A的行数和列数。
	　　接下来n行，每行m个整数，表示矩阵A。
	输出格式
	　　输出一行，包含一个整数，表示A中最大的子矩阵中的元素和。
	样例输入
	3 3
	-1 -4 3
	3 4 -1
	-5 -2 8
	样例输出
	10
	样例说明
	　　取最后一列，和为10。
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
		for (int start = 0; start < n; start++) { // 开始行
			long[] ring = new long[m];
			long[] dp = new long[m];
			for (int end = start; end < n; end++) { // 结束行
				for (int j = 0; j < m; j++) // 计算start~end行的每一列元素和
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