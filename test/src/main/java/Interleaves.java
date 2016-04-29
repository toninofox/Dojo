
public class Interleaves {
	    public static String interleave(String str1, String str2) {
	        StringBuffer result = new StringBuffer();
	        int maxLength = str1.length() > str2.length()? str1.length() : str2.length();
	        for(int i = 0; i< maxLength; i++){
	        	if(str1.length() >= i+1){
	        		result.append(str1.charAt(i));
	        	}
	        	
	        	if(str2.length() >= i+1){
	        		result.append(str2.charAt(i));
	        	}
	        }
	    	
	    	return result.toString();
	    }
	    
	    public static void main(String[] args) {
			System.out.println(interleave("abc", "1"));
		}
}
