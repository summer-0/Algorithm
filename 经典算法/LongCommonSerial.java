package day14;

public class LongCommonSerial {
	/**
	 * �������ַ�������������У�
	 * 
	 *           0              �� i=0 �� j=0
	 *  C[i,j] = C[i-1,j-1]+1   ��i,j>0 , Xi = Yj
	 *           max{ C[i,j-1], C[i-1,j] }  ��i,j>0 , Xi ������ Yi
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        int findLCS = findLCS("android", "random");
        System.out.println("������г���:"+findLCS);
	}
	
	public static int findLCS(String A, String B){
		int n = A.length();
		int m = B.length();
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] dp = new int[n][m];
		//��һ��
		for(int i=0; i<n; i++){
			if(a[i] == b[0]){
				dp[i][0] = 1;
				for(int j=i+1; j<n; j++){
					dp[j][0] = 1;
				}
				break; //��������,Ҳ���Բ�����
			}
		}
		//��һ��
		for(int i=0; i<m; i++){
			if(a[0] == b[i]){
				dp[0][i] = 1;
				for(int j=i+1; j<m; j++){
					dp[0][j] = 1;
				}
				break;
			}
		}
		// �ӣ�1��1����ʼ
		for(int i=1; i<n; i++){
			for(int j=1; j<m; j++){
				if(a[i] == b[j]){
					dp[i][j] = dp[i-1][j-1] + 1;   
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		//��ӡ����
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[n-1][m-1];
	}

}
