package org.csu.coderlee.interview.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abcdeafghc"));
        System.out.println(lengthOfLongestSubstring1("abcdeafghc"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        char start = s.charAt(0);
        char end;
        HashSet<Character> occ = new HashSet<>();
        occ.add(start);
        for (int i = 1; i < s.length(); i++) {
            int j = i;
            end = s.charAt(j);
            while (!occ.contains(end)) {
                occ.add(end);
                j = j + 1;

                if (j >= s.length()) break;
                end = s.charAt(j);
            }
            result = occ.size() > result? occ.size() : result;

        }

        return result;
    }

    /**
     *
     * @param s  e.g.  abcdefa
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {

        int j = 0;
        int result = 0;
        Set<Character> occ = new HashSet<>();
        occ.add(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {

            if (i != 0) {
                occ.remove(i - 1);
            }
            while (j < s.length() && !occ.contains(s.charAt(j+1))) {
                occ.add(s.charAt(j + 1));
                j++;
            }
            result = Math.max(result, occ.size());
        }
        return result;
    }

    public static int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring4(String s) {

        Set<Character> occ = new HashSet<>();
        int result = 0;
        int rightPoint = 0;
        for (int i = 0; i < s.length(); i++) {

            if (i > 0) {
                occ.remove(s.charAt(i - 1));
            }

            while (rightPoint + 1 < s.length() && !occ.contains(s.charAt(rightPoint + 1))) {
                occ.add(s.charAt(i + 1));
                rightPoint++;
            }

            result = Math.max(result, occ.size());
        }

        return result;
    }

}
