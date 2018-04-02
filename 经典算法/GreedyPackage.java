package day13;

public class GreedyPackage {
/**
 * Ì°ÐÄËã·¨£º
 * 
 * @param args
 */
	
	
	private int MAX_WEIGHT = 150;
	private int[] weights = new int[]{35,30,60,50,40,10,25};
	private int[] values = new int[]{10,40,30,50,35,40,30};
	
	private void packageGreedy(int capacity, int weights[], int values[]){
		int N = weights.length;
		double[] r = new double[N];
		for(int i=0; i<N; i++){
			r[i] = (double)values[i] / weights[i];
		}
		
	}
	
	public static void main(String[] args) {

	}

	
}
