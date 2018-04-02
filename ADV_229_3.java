package javaB;
import java.util.Scanner;
/**�ϲ�ʯ��(��̬�滮)
 * ��������
������һ��ֱ������n��ʯ�ӣ�ÿ����һ����������ÿ�ο��Խ��������ڵ�ʯ�Ӻϲ����ϲ���������ѵ��м�λ�ã��ϲ��ķ���Ϊ����ʯ�ӵ��������������ʯ�Ӻϲ���һ�ѵ���С���ѡ�
	�����ʽ
	���������һ�а���һ������n����ʾʯ�ӵĶ�����
	����������һ�У�����n����������˳�����ÿ��ʯ�ӵĴ�С ��
	�����ʽ
	�������һ����������ʾ�ϲ�����С���ѡ�
	��������
	5
	1 2 3 4 5
	�������
	33
	��������
	5
	7 5 6 7 100
	�������
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