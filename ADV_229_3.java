package javaB;
import java.util.Scanner;
/**合并石子(动态规划)
 * 问题描述
　　在一条直线上有n堆石子，每堆有一定的数量，每次可以将两堆相邻的石子合并，合并后放在两堆的中间位置，合并的费用为两堆石子的总数。求把所有石子合并成一堆的最小花费。
	输入格式
	　　输入第一行包含一个整数n，表示石子的堆数。
	　　接下来一行，包含n个整数，按顺序给出每堆石子的大小 。
	输出格式
	　　输出一个整数，表示合并的最小花费。
	样例输入
	5
	1 2 3 4 5
	样例输出
	33
	样例输入
	5
	7 5 6 7 100
	样例输出
	175
 * @author 49944
 *
 */
public class ADV_229_3 {
    
    public long getSum(long[] A, int a, int b) {
        long sum = 0;
        for(int i = a;i <= b;i++)
            sum += A[i];
        return sum;
    }
    
    public void printResult(long[] A) {
        if(A.length == 1) {
            System.out.println(A[0]);
            return;
        }
        long[][] dp = new long[A.length + 1][A.length + 1];
        for(int len = 2;len <= A.length;len++) {
            for(int i = 1, j = len;j <= A.length;i++,j++) {
                long min = Long.MAX_VALUE;
                for(int k = i;k < j;k++) {
                    if(min > dp[i][k] + dp[k + 1][j] + getSum(A, i - 1, j - 1))
                        min = dp[i][k] + dp[k + 1][j] + getSum(A, i - 1, j - 1);
                }
                dp[i][j] = min;
            }
        }
        System.out.println(dp[1][A.length]);
        return;
    }
    
    public static void main(String[] args) {
    	ADV_229_3 test = new ADV_229_3();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n < 1 || n > 1000)
            return;
        long[] A = new long[n];
        for(int i = 0;i < n;i++) {
            A[i] = in.nextLong();
        }
        test.printResult(A);
    }
}