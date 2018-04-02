package day14;

public class Queen {
/**
 * 八皇后：回溯法
 * @param args
 */
	public static int num = 0; //累计方案
	public static final int MAXQUEEN = 8;
	public static int[] cols = new int[MAXQUEEN]; //定义cols数组，表示8列棋子摆放的位置
	/**
	 * 填第n列的皇后
	 * @param n
	 */
	public void getCount(int n){
		boolean[] rows = new boolean[MAXQUEEN]; //记录每列每个方格是否可以放皇后
		//遍历哪些之前不能放的
		for(int m=0; m<n; m++ ){
			rows[cols[m]] = true;
			int d = n - m; //斜对角
			//正斜方向
			if(cols[m]-d >= 0){
				rows[cols[m] - d] = true;
			}
			//反斜方向
			if(cols[m]+d <= (MAXQUEEN-1)){
				rows[cols[m]+d] = true;
			}
		}
		//到此为止知道了那些位置不能放皇后
		for(int i=0; i<MAXQUEEN; i++){
			if(rows[i]){
				//不能放
				continue;//结束本次循环
			}
			cols[n] = i;
			//下面可能仍然右合法位置
			if(n < MAXQUEEN-1){
				getCount(n+1);
			}else{  ///回溯
				//找到了完整的一套方案
				num++;
				printQueen();
			}
		}
	}
	
	private void printQueen() {
		// TODO Auto-generated method stub
		System.out.println("第 "+num+" 种方案");
		for(int i=0; i<MAXQUEEN; i++){
			for(int j=0; j<MAXQUEEN; j++){
				if(i  == cols[j]){
					System.out.print("0 ");
				}else{
					System.out.print("+ ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
         Queen queen = new Queen();
         queen.getCount(0); //从0开始
	}

}
