
public class LongestFlat {
	
	 public static int longest_flat(int[] array) {
	        int max = -1;
	        int current = 0;
	        int last =-1;
	        for (int i : array) {
				if(last == i){
					current++;
				} else {
					last = i;
					if(current > max){
						max = current;
						current = 1;
					} else {
						current = 0;
					}
				}
			}
	        //last iteration
	        if(current > max){
				max = current;
			}
	        return max;
	    }
	    
	    public static void main(String[] args) {
			System.out.println(longest_flat(new int[]{1,1,1}));
		}
}
