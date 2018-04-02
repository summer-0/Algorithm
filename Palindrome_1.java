package DTGH;
/**
 * ����һ���ַ����������һ����Ч�㷨����������������Ӵ��ĳ��ȡ�
	�����ַ���A�Լ����ĳ���n���뷵��������Ӵ��ĳ��ȡ�
	����������"abc1234321ab",12
	���أ�7
 * @author 49944
 *
 */
public class Palindrome_1 {
	private static int max = 0;
	private static String result = "";

	public static int getLongestPalindrome(String A, int n) {
		if (n == 1) {
			return n;
		}
		for (int i = 0; i < n; i++) {
			checkPalindromeExpand(A, i, i);   //  ������������ɢ���ķ���         �磺         efa bcb eil 
			
			checkPalindromeExpand(A, i, i + 1);  //       g4ea edbbde ge4
		}
		return max;
	}

	public static void checkPalindromeExpand(String s, int low, int high) {
		while (low >= 0 && high < s.length()) {
			if (s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > max) {
					max = high - low + 1;
					result = s.substring(low, high + 1);
				}
				low--;
				high++;
			} else {
				return;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
        int longestPalindrome = getLongestPalindrome(
        		"dfbcbtyhrt", 10);
        System.out.println(longestPalindrome);
        long end = System.currentTimeMillis();
        System.out.println(end - start +"ms");
	}

}
