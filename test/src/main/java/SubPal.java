import java.util.HashSet;
import java.util.Set;

public class SubPal {

	private static Set<String> getSubPalindromic(String input) {
		String s1 = "";
		int length = input.length();
		Set<String> palindromes = new HashSet<String>();
		for (int i = 2; i <= length; i++) {
			for (int j = 0; j <= length; j++) {
				int k = i + j - 1;
				if (k >= length){
					continue;
				}
				s1 = input.substring(j, i + j);
				String reverse = new StringBuilder(s1).reverse().toString();
				if (s1.equals(reverse)) {
					palindromes.add(s1);
				}
			}

		}
		return palindromes;
	}
	
	public static int longest_palindromic_substring(String input){
		Set<String> subPal = getSubPalindromic(input);
		int maxLength = 0;
		for (String value : subPal) {
			if(value.length()>maxLength){
				maxLength = value.length();
			}
		}
		return maxLength;
	}

}
