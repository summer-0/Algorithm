package day13;

public class SportsSchedule {
/**
 *   1 2 3 4 5 6 7 8
 *   2 1 4 3 6 5 8 7
 *   3 4 1 2 7 8 5 6
 *   4 3 2 1 8 7 6 5           
 *   5 6 7 8 1 2 3 4
 *   6 5 8 7 2 1 4 3
 *   7 8 5 6 3 4 1 2
 *   8 7 6 5 4 3 2 1
 * @param args
 */
	public static void main(String[] args) {

		int table[][] = new int[8][8];
		int n = 8;
		scheduleTable(table, n);
		int t = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(table[i][j]+" ");
				t++;
				if(t % n == 0){
					System.out.println();
				}
			}
		}
	}
	
	public static void scheduleTable(int[][] table, int n){
		if(n == 1){
			table[0][0] = 1;
		}else{
			//Ìî³ä×óÉÏÇøÓò¾ØÕó
			int m = n/2;
			scheduleTable(table, n/2);
			//Ìî³äÓÒÉÏÇøÓò¾ØÕó
			for(int i=0; i<m; i++){
				for(int j=m; j<n; j++){
					table[i][j] = table[i][j-m] + m;//
				}
			}
			//Ìî³ä×óÏÂÇøÓò¾ØÕó
			for(int i=m; i<n; i++){
				for(int j=0; j<m; j++){
					table[i][j] = table[i-m][j] + m;//
				}
			}
			//Ìî³äÓÒÏÂÇøÓò¾ØÕó
			for(int i=m; i<n; i++){
				for(int j=m; j<n; j++){
					table[i][j] = table[i-m][j-m];//
				}
			}
		}
	}

}
