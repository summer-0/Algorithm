package day14;

public class LongCommonSerial {
	/**
	 * 求两个字符串的最长公共序列：
	 * 
	 *           0              若 i=0 或 j=0
	 *  C[i,j] = C[i-1,j-1]+1   若i,j>0 , Xi = Yj
	 *           max{ C[i,j-1], C[i-1,j] }  若i,j>0 , Xi 不等于 Yi
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        int findLCS = findLCS("android", "random");
        System.out.println("最长子序列长度:"+findLCS);
	}
	
	public static int findLCS(String A, String B){
		int n = A.length();
		int m = B.length();
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] dp = new int[n][m];
		//第一列
		for(int i=0; i<n; i++){
			if(a[i] == b[0]){
				dp[i][0] = 1;
				for(int j=i+1; j<n; j++){
					dp[j][0] = 1;
				}
				break; //可以跳出,也可以不跳出
			}
		}
		//第一行
		for(int i=0; i<m; i++){
			if(a[0] == b[i]){
				dp[0][i] = 1;
				for(int j=i+1; j<m; j++){
					dp[0][j] = 1;
				}
				break;
			}
		}
		// 从（1，1）开始
		for(int i=1; i<n; i++){
			for(int j=1; j<m; j++){
				if(a[i] == b[j]){
					dp[i][j] = dp[i-1][j-1] + 1;   
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		//打印矩阵
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[n-1][m-1];
	}

}
