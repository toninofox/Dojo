import java.util.HashSet;
import java.util.Set;

public class Solution_elevator {
	
	public int solution(int[] A, int[] B, int floors, int maxNumber, int maxWeigth) {
		Set<Integer> lstFloors = new HashSet<>();
		long countWeight = 0;
		int stops = 0;
		int maxPersons = 0;
		int currPerson = 0;
		boolean moveElevator = false;
		while (currPerson < A.length) {
			if (canEnter(A, maxNumber, maxWeigth, maxPersons, currPerson, countWeight)) {
				countWeight += A[currPerson];
				maxPersons++;
				lstFloors.add(B[currPerson]);
				if (isLast(A, currPerson)) {
					moveElevator = true;
				}
				currPerson++;
			} else {
				moveElevator = true;
			}

			if (moveElevator) {
				moveElevator = false;
				stops += lstFloors.size() + 1;
				lstFloors.clear();
				maxPersons = 0;
				countWeight = 0;
			}
		}

		return stops;
	}

	private boolean isLast(int[] A, int currPerson) {
		return currPerson == A.length - 1;
	}

	private boolean canEnter(int[] A, int maxNumber, int maxWeigth, int maxPersonsCount, int currPerson, long countWeight) {
		return maxWeigth >= (countWeight + A[currPerson]) && maxNumber >= (maxPersonsCount + 1);
	}
	
	public static void main(String[] args) {
		int[] A = {40, 40, 100,80,20};
		int[] B = {3, 3, 2,2,3};
		System.out.println(new Solution_elevator().solution(A, B, 3, 5, 200));
	}
}
