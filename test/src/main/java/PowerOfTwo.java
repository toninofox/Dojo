
public class PowerOfTwo {
	
	public static int nearest_power_of_two(int n) {
        int result = -1;
        
        for(int i = 1;i<=n;i++){
        	if((i & (i - 1)) == 0){
        		if(i>result){
        			result = i;
        		}
        	}
        }
        
        return result;
    }
	    
	    public static void main(String[] args) {
			System.out.println(nearest_power_of_two(0));
		}
}
