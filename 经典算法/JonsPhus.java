package day14;

public class JonsPhus {
/**
 * 
 * @param args
 */
	public static int N = 20;
	public static int M = 5; //����M���ǲ�һ����
	
	class Node{
		int val; //�±�
		Node next;
		public Node(int val) {
			super();
			this.val = val;
		}
	}
	public void killNode(){
		Node header = new Node(1); //��һ�����
		Node x = header; //Ŀǰ���㵽��
		for(int i=2; i<=N; i++){
			x = (x.next = new Node(i)); 
			
		}
		x.next = header; //ͷβ���
		System.out.println("�������˳��Ϊ��");
		while(x != x.next){
			//���ٻ���2�ˣ���Ȼ����
			for(int i=1; i<M; i++){
				x = x.next;
			}
			System.out.println(x.next.val + "���ɵ�");
			x.next = x.next.next;
		}
		System.out.println("���������˶��ǣ�"+x.val);
	}
	
	public static void main(String[] args) {
        JonsPhus jonsPhus = new JonsPhus();
        jonsPhus.killNode();
	}

}
