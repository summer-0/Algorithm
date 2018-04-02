package day14;

public class Queen {
/**
 * �˻ʺ󣺻��ݷ�
 * @param args
 */
	public static int num = 0; //�ۼƷ���
	public static final int MAXQUEEN = 8;
	public static int[] cols = new int[MAXQUEEN]; //����cols���飬��ʾ8�����Ӱڷŵ�λ��
	/**
	 * ���n�еĻʺ�
	 * @param n
	 */
	public void getCount(int n){
		boolean[] rows = new boolean[MAXQUEEN]; //��¼ÿ��ÿ�������Ƿ���ԷŻʺ�
		//������Щ֮ǰ���ܷŵ�
		for(int m=0; m<n; m++ ){
			rows[cols[m]] = true;
			int d = n - m; //б�Խ�
			//��б����
			if(cols[m]-d >= 0){
				rows[cols[m] - d] = true;
			}
			//��б����
			if(cols[m]+d <= (MAXQUEEN-1)){
				rows[cols[m]+d] = true;
			}
		}
		//����Ϊֹ֪������Щλ�ò��ܷŻʺ�
		for(int i=0; i<MAXQUEEN; i++){
			if(rows[i]){
				//���ܷ�
				continue;//��������ѭ��
			}
			cols[n] = i;
			//���������Ȼ�ҺϷ�λ��
			if(n < MAXQUEEN-1){
				getCount(n+1);
			}else{  ///����
				//�ҵ���������һ�׷���
				num++;
				printQueen();
			}
		}
	}
	
	private void printQueen() {
		// TODO Auto-generated method stub
		System.out.println("�� "+num+" �ַ���");
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
         queen.getCount(0); //��0��ʼ
	}

}
