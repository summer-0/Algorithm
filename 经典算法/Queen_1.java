package day14;

public class Queen_1 {

	public static int sum = 0;
	public static final int MAXQUEEN = 8;
	public static int[] cols = new int[MAXQUEEN];//存放八皇后的位置(第几行) 如：cols[] = {0,2,5,}; //第0行，第2行，第5行
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Queen_1 queen = new Queen_1();
        queen.getCount(0);
	}
    public  void getCount(int n){ //就第n列的八皇后位置
    	boolean rows[] = new boolean[MAXQUEEN];
    	//遍历第n列之前的不能再放皇后的位置
    	for(int m=0; m<n; m++){
    		rows[cols[m]] = true; //如：cols[] = {0,2,5,}; //第0行，第2行，第5行
    		//然后斜对角不能放
    		int d = n-m; //斜对角的（行、列坐标）差值
    		//  方向为“\” 的斜对角
    		if(cols[m]+d < MAXQUEEN){
    			rows[cols[m]+d] = true;
    		}
    	    //  方向为“/” 的斜对角
    		if(cols[m]-d >= 0){
    			rows[cols[m]-d] = true;
    		}
    	}
    	//不能放皇后的位置遍历之后
    	//开始遍历能放皇后的位置
    	for(int i=0; i<MAXQUEEN; i++){
    		if(rows[i]){  //rows[i] = true;  这行不能再放皇后了  
    			continue; //跳出本次循环
    		}
    		cols[n] = i; //把 i行 记录再第 n 列中
    		//继续 得到 n+1列 放皇后的位置
    		if(n+1 < MAXQUEEN){
    			getCount(n+1);
    		}else{
    			sum++; // 遍历完一种
    			printQueen();
    		}
    	}
    }
	private void printQueen() {
		// TODO Auto-generated method stub
		System.out.println("第 "+sum+" 种方案");
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
}
