package day12;

public class HanNoTa {
/**
 * ��ŵ��
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
			hanNoTa(n-1, from, to, dependOn);//����ABC˳��ı�//   ��һ�����Ƚ�n-1�����Ӵ�A����CŲ��B
			move(n, from, to);//��n������ӣ����̣���AŲ��C
			hanNoTa(n-1, dependOn, from, to);//��n-1������(֮ǰ�ĵ������ϵ�����)��B����AŲ��C
		}
	

	}
	public void move(int i, char from, char to) {
		System.out.println("��"+i+"�����Ӵ�"+from+"----->"+to);
	}
}
