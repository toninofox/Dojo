import java.util.ArrayList;
import java.util.List;

class Solution_ticket {

	private static final int WEEKLY_COST = 7;
	private static final int DAILYCOST = 2;
	private static final int MONTHLYCOST = 25;

	public int solution(int[] A) {
		int weeklyValidation = A[0];
		int weekCount = 0;
		int dayCount = 0;
		List<Integer> sub = new ArrayList<>();
		for (int i = 0; i <  A.length; i++) {
			int currentDay = A[i];
			if ( isWeeklyTicketValid(weeklyValidation, currentDay) && !isLastDay(A, i)) {
//				System.out.println("Weekly ticket is already valid");
				sub.add(currentDay);
			} else {
				 if(isLastDay(A, i)){
						sub.add(currentDay);

				 }
				weeklyValidation = currentDay;
				if(WEEKLY_COST<getDailyCost(sub)){
//					System.out.println("1 Weekly Ticket is cheaper then "+sub.size()+" daily ones");
					weekCount++;
				} else {
//					System.out.println(sub.size()+" Daily Tickets is cheaper then 1 weekly one");
					dayCount += sub.size();
				}
				sub.clear();
				sub.add(currentDay);
			}
		}
		int totalCost = weekCount*WEEKLY_COST+dayCount*DAILYCOST;
		return totalCost < MONTHLYCOST ? totalCost : MONTHLYCOST;
	}


	private boolean isWeeklyTicketValid(int initialDay, int currentDay) {
		return currentDay - initialDay < 7;
	}


	private boolean isLastDay(int[] A, int i) {
		return i==A.length-1;
	}

	
	private int getDailyCost(List<Integer> sub) {
		return sub.size()*DAILYCOST;

	}
	
	public static void main(String[] args) {
		int[] input = {1,2,4,5,7,22,23,24,25,26,27};
		System.out.println(new Solution_ticket().solution(input));
	}

}