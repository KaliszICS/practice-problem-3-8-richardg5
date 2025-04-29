import java.util.HashMap;

public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int fib(int num) {
		HashMap<Integer, Integer> map = new HashMap<>();
		return fibHelper(num, map);
	}

	public static int fibHelper(int num, HashMap<Integer, Integer> map) {
		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else if (map.containsKey(num)) {
			return map.get(num);
		}

		int result = fibHelper(num - 1, map) + fibHelper(num - 2, map);
		map.put(num, result);
		return result;
	}

	public static int minCostClimbingStairs(int[] num) {
		HashMap<Integer, Integer> map = new HashMap<>();
		if (num.length == 1) {
			return stairsHelper(num,0, map);
		}
		return Math.min(stairsHelper(num, 0, map), stairsHelper(num, 1, map));
	}

	public static int stairsHelper(int[] nums, int pos, HashMap<Integer, Integer> map) {
		if (pos >= nums.length) {
			return 0;
		} else if (map.containsKey(pos)) {
			return map.get(pos);
		}

		int result = Math.min(stairsHelper(nums, pos + 1, map), stairsHelper(nums, pos + 2, map)) + nums[pos];
		map.put(pos, result);
		return result;
	}
}
