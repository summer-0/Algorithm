package DTGH;

import java.util.Scanner;

/**
 * 给定一个字符串，问是否能通过添加一个字母将其变为回文串。 输入描述: 一行一个由小写字母构成的字符串，字符串长度小于等于10。 输出描述:
 * 输出答案(YES\NO). 示例1 输入 coco 输出 YES
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
	 * 判断是否回文
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
