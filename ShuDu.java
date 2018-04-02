package DTGH;

import java.util.Scanner;

/**
 *   题目描述
	数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。
	输入描述:
	输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。
	输出描述:
	输出九行，每行九个空格隔开的数字，为解出的答案。
	
  0 0 5 3 0 0 0 0 0
  8 0 0 0 0 0 0 2 0 
  0 7 0 0 1 0 5 0 0 
  4 0 0 0 0 5 3 0 0
  0 1 0 0 7 0 0 0 6 
  0 0 3 2 0 0 0 8 0 
  0 6 0 5 0 0 0 0 9 
  0 0 4 0 0 0 0 3 0
  0 0 0 0 0 9 7 0 0 
 * 程序应该输出： 
 * 145327698 
 * 839654127 
 * 672918543 
 * 496185372 
 * 218473956 
 * 753296481
 * 367542819 
 * 984761235 
 * 521839764 
 * @author 49944
 *
 */
public class ShuDu {
    private static int N = 9;
	private static int arrays[][];
	public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       arrays = new int[N][N];
       for(int i=0; i<N; i++){
    	   for(int j=0; j<N; j++){
    		   arrays[i][j] = scan.nextInt();
    	   }
       }
       setShuDu(0, 0);
       //System.out.println(" hjwelrfjwaeojrf'opawjfrop'awe");
	}
	/**
	 * 坐标
	 * @param m: 行
	 * @param n: 列
	 */
	private static void setShuDu(int row, int col) {
		if(row >= 9){
			print();
			//System.out.println("ms");
            //System.exit(0);
			return;
		}
		//判断格子的是否是0
		if(arrays[row][col] == 0){
			for(int i=1; i<=9; i++){
				if(noRowColRepeat(row, col, i) && noSectionRepeat(row, col, i)){
					//表示可以放入i这个数字
					arrays[row][col] = i;
					setShuDu(row + (col + 1) / 9, (col + 1) % 9);
					//上一步若不行，回退一步
					arrays[row][col] = 0;
				}
			}
		}else{
			setShuDu(row + (col + 1) / 9, (col + 1) % 9);
		}
	}
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arrays[i][j] + " ");
			}
			System.out.println();
		}
	}
	/**
	 * 九宫格
	 * @param row
	 * @param col
	 * @param n
	 * @return
	 */
	private static boolean noSectionRepeat(int row, int col, int n) {
		int startRow, startCol;
		if(row <= 2){
			startRow = 0;
		}else if(row <=5){
			startRow = 3;
		}else{
			startRow = 6;
		}
		
		if(col <= 2){
			startCol = 0;
		}else if(col <=5){
			startCol = 3;
		}else{
			startCol = 6;
		}
		for(int i=startRow; i<startRow+3; i++){
			for(int j=startCol; j<startCol+3; j++){
				if(arrays[i][j] == n){
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * 同行同列
	 * @param row
	 * @param col
	 * @param n
	 * @return
	 */
	private static boolean noRowColRepeat(int row, int col, int n) {
		//判断行
		for(int k=0; k<N; k++){
			if(arrays[k][col] == n){
				return false;
			}
		}
		//判断列
		for(int k=0; k<N; k++){
			if(arrays[row][k] == n){
				return false;
			}
		}
		
		return true;
	}
	
}
