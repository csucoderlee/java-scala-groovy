package org.csu.coderlee.interview.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 15 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                    while (left < nums.length && nums[left] == nums[left - 1]) left++;
                    while (right > left && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
