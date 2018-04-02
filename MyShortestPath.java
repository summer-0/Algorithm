package day01;
/**
 * 最短路径(动态规划)
 * @author 49944
 *
 */
public class MyShortestPath {

	private static int[][] arrays;
    private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
        arrays = new int[][] {
        		{5,1,1,4,6,11},
        		{5,1,4,3,8,2},
        		{7,2,6,7,2,4},
        		{8,4,15,6,4,2},
        		{1,0,8,12,4,3}};
       int n = arrays.length;
       int m = arrays[0].length;
       myShortestPath(n, m);
       System.out.println(min);
	}
	/**
	 * 
	 * @param n: 行
	 * @param m: 列
	 */
	private static void myShortestPath(int n, int m) {
        if(n == 0 && m == 0){
        	return;
        }		
        int[][] temp = new int [n][m];
        temp[0][0] = arrays[0][0];
        //两条边上的值
        //行
        for(int i=1; i<n; i++){
        	temp[i][0] = temp[i-1][0] + arrays[i][0];
        }
        //列
        for(int i=1; i<m; i++){
        	temp[0][i] = temp[0][i-1] + arrays[0][i];
        }
        for(int i=1; i<n; i++){
        	for(int j=1; j<m; j++){
        		if(temp[i][j-1] < temp[i-1][j]){
        			temp[i][j] = temp[i][j-1] + arrays[i][j];
        			
        		}else{
        			temp[i][j] = temp[i-1][j] + arrays[i][j];
        			
        		}
        	}
        }
       
        min = temp[n-1][m-1];
        //打印一下temp 表
        for(int i=0; i<n; i++){
        	for(int j=0; j<m; j++){
        		System.out.print(temp[i][j]+"  ");
        	}
        	System.out.println();
        }
	}

}
