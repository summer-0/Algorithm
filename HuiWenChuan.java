package DTGH;

import java.util.Scanner;

/**
 * ����һ���ַ��������Ƿ���ͨ�����һ����ĸ�����Ϊ���Ĵ��� ��������: һ��һ����Сд��ĸ���ɵ��ַ������ַ�������С�ڵ���10�� �������:
 * �����(YES\NO). ʾ��1 ���� coco ��� YES
 * 
 * @author 49944
 *
 */
public class HuiWenChuan {
	private static int is = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char[] charArray = str.toCharArray();
		getCharArray(charArray);
		if (is == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	private static void getCharArray(char[] charArray) {
		for (int j = 0; j <= 26; j++) {
			char[] newChar = new char[charArray.length + 1];
			char ch = (char) ('a' + j);
			for (int k = 0; k < newChar.length; k++) {
				newChar[k] = ch;
				int index = 0;
				for (int m = 0; m < newChar.length  && index<charArray.length; m++) {
					if(m == k){
						continue;
					}
					newChar[m] = charArray[index];
					index++;
				}
				if (judeg(newChar) && index == charArray.length) {
					is = 1;
					return;
				}
			}
			
		}

	}

	/**
	 * �ж��Ƿ����
	 * 
	 * @param newChar
	 */
	private static boolean judeg(char[] newChar) {
		int i = 0;
		int j = newChar.length - 1;
		while (i < j) {
			if (newChar[i] != newChar[j]) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
