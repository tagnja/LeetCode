//Given a string s, find the length of the longest substring without repeating c
//haracters.
//
//
// Example 1:
//
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//
// Example 2:
//
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//
// Example 3:
//
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a
//substring.
//
//
// Example 4:
//
//
//Input: s = ""
//Output: 0
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
//
// Related Topics Hash Table Two Pointers String Sliding Window
// 👍 13558 👎 700


package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters{
  public static void main(String[] args) {
       Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
       // abcabcbb 3
      System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
      // bbbbb 1
      System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
      // pwwkew 3
      System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
      // "" 0
      System.out.println(solution.lengthOfLongestSubstring(""));
      System.out.println(solution.lengthOfLongestSubstring("aab"));

  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
         * Wrong anwser: input 'aab', output 1, expect 2
         * Result:
         * T(n) = O(n^2), S(n) = O(n)
         * Runtime faster than 13.38%,
         * Memory usage less than 43.58%
         */
        if (s == null || s.length() == 0) {
            return 0;
        }
        // from index start=0, find map contains the character
        // if contains, try update max length and refresh current length, restart from start=repeat index, clear map
        // if not contains, put the character to map,  add the length of substring
        Map<String, Integer> characterIndexMap = new HashMap<>();
        int i = 0;
        int length = 0;
        int maxLength = 0;

        while (i < s.length()) {
            String current = String.valueOf(s.charAt(i));
            if (characterIndexMap.containsKey(current)) {
                if (length > maxLength) {
                    maxLength = length;
                }
                length = 0;
                i = characterIndexMap.get(current);
                characterIndexMap.clear();
            } else {
                characterIndexMap.put(current, i);
                length ++;
            }
            i++;
        }

        if (length > maxLength) {
            maxLength = length;
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
