import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                int[] return_array = new int[2];
                return_array[0] = i;
                return_array[1] = map.get(complement);
                return return_array;
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Solution Found");
    }
}
