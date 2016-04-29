class Solution_bug {
	
	int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < 1 + l && p <= l/2; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }
	
    int solution2(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < 1 + l && p <= l / 2; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }
    
    static int getBinaryPeriodForInt(int n) {
        int[] d = new int[30];
        int l = 0, res = -1;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }

        for (int p = 1; p < l; p++) {
            if (p <= l / 2) {
                boolean ok = true;
                for (int i = 0; i < l - p; i++) {
                    if (d[i] != d[i + p]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    res = p;
                }
            }
        }

        return res;
    }
    
    public static void main(String[] args) {
    	System.out.println(Integer.toString(1000,2));
		System.out.println(new Solution_bug().solution(955));
		System.out.println(new Solution_bug().solution(1000));
		System.out.println(new Solution_bug().solution2(1000));
		System.out.println(new Solution_bug().getBinaryPeriodForInt(1000));
	}
}