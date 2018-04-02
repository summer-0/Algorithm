package day14;

public class Queen_1 {

	public static int sum = 0;
	public static final int MAXQUEEN = 8;
	public static int[] cols = new int[MAXQUEEN];//��Ű˻ʺ��λ��(�ڼ���) �磺cols[] = {0,2,5,}; //��0�У���2�У���5��
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Queen_1 queen = new Queen_1();
        queen.getCount(0);
	}
    public  void getCount(int n){ //�͵�n�еİ˻ʺ�λ��
    	boolean rows[] = new boolean[MAXQUEEN];
    	//������n��֮ǰ�Ĳ����ٷŻʺ��λ��
    	for(int m=0; m<n; m++){
    		rows[cols[m]] = true; //�磺cols[] = {0,2,5,}; //��0�У���2�У���5��
    		//Ȼ��б�Խǲ��ܷ�
    		int d = n-m; //б�Խǵģ��С������꣩��ֵ
    		//  ����Ϊ��\�� ��б�Խ�
    		if(cols[m]+d < MAXQUEEN){
    			rows[cols[m]+d] = true;
    		}
    	    //  ����Ϊ��/�� ��б�Խ�
    		if(cols[m]-d >= 0){
    			rows[cols[m]-d] = true;
    		}
    	}
    	//���ܷŻʺ��λ�ñ���֮��
    	//��ʼ�����ܷŻʺ��λ��
    	for(int i=0; i<MAXQUEEN; i++){
    		if(rows[i]){  //rows[i] = true;  ���в����ٷŻʺ���  
    			continue; //��������ѭ��
    		}
    		cols[n] = i; //�� i�� ��¼�ٵ� n ����
    		//���� �õ� n+1�� �Żʺ��λ��
    		if(n+1 < MAXQUEEN){
    			getCount(n+1);
    		}else{
    			sum++; // ������һ��
    			printQueen();
    		}
    	}
    }
	private void printQueen() {
		// TODO Auto-generated method stub
		System.out.println("�� "+sum+" �ַ���");
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
