package day12;

public class HanNoTa {
/**
 * 汉诺塔
 * @param args
 */
	public static void main(String[] args) {
         HanNoTa hanNoTa = new HanNoTa();
         hanNoTa.hanNoTa(72, 'A', 'B', 'C'); 
	}

	public void hanNoTa(int n, char from, char dependOn, char to){
		if(n == 1){
			move(n, from , to);
		}else{
			hanNoTa(n-1, from, to, dependOn);//这里ABC顺序改变//   第一步，先将n-1个盘子从A利用C挪到B
			move(n, from, to);//将n这个盘子（底盘）从A挪到C
			hanNoTa(n-1, dependOn, from, to);//将n-1个盘子(之前的底盘以上的盘子)从B利用A挪到C
		}
	

	}
	public void move(int i, char from, char to) {
		System.out.println("第"+i+"个盘子从"+from+"----->"+to);
	}
}
