package org.csu.coderlee.interview.bytedance;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum1 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 6, 7};
        int target = 8;
        int[] ints = twoSum1(nums, target);
        if (ints != null) {
            System.out.println(ints[0] + " - " + ints[1]);
        }

        ints = twoSum2(nums, target);
        if (ints != null) {
            System.out.println(ints[0] + " - " + ints[1]);
        }

        ints = twoSum3(nums, target);
        if (ints != null) {
            System.out.println(ints[0] + " - " + ints[1]);
        }
    }

    /**
     * 暴力法，双层for循环遍历
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static int[] twoSum2(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            //这里如果不加 && map.get(complete) != i ， 就会出现同一个元素使用两次满足相加等于target
            if (map.containsKey(complete) && map.get(complete) != i) {
                return new int[]{map.get(complete), i};
            }
        }

        return null;
    }
    private static int[] twoSum3(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}
