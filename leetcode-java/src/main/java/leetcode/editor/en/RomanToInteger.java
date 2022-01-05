//Roman numerals are represented by seven different symbols: I, V, X, L, C, D
//and M.
//
//
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//
// For example, 2 is written as II in Roman numeral, just two one's added
//together. 12 is written as XII, which is simply X + II. The number 27 is written as
//XXVII, which is XX + V + II.
//
// Roman numerals are usually written largest to smallest from left to right.
//However, the numeral for four is not IIII. Instead, the number four is written as
//IV. Because the one is before the five we subtract it making four. The same
//principle applies to the number nine, which is written as IX. There are six
//instances where subtraction is used:
//
//
// I can be placed before V (5) and X (10) to make 4 and 9.
// X can be placed before L (50) and C (100) to make 40 and 90.
// C can be placed before D (500) and M (1000) to make 400 and 900.
//
//
// Given a roman numeral, convert it to an integer.
//
//
// Example 1:
//
//
//Input: s = "III"
//Output: 3
//Explanation: III = 3.
//
//
// Example 2:
//
//
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
//
//
// Example 3:
//
//
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 15
// s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
// It is guaranteed that s is a valid roman numeral in the range [1, 3999].
//
// Related Topics Hash Table Math String 👍 2707 👎 185


package leetcode.editor.en;
public class RomanToInteger{
  public static void main(String[] args) {
       Solution solution = new RomanToInteger().new Solution();
       System.out.println(solution.romanToInt("I"));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int romanToInt(String s) {
        // "", I~III, IV, V~VIII, IX, 0~9: start with I or V
        // "", X~XXX, XL, L~LXXX, XC, 10~90: start with X or L
        String[] romanSymbols = {"I", "V", "X", "L", "C", "D", "M"};
        int[] romanValues = {1, 5, 10, 50, 100, 500, 1000};
        int result = 0;
        int i = 0;
        while (i < 7) {
            int index = -1;
            int indexI = s.indexOf(romanSymbols[i]);
            int indexV = -1;
            if (i < romanSymbols.length - 1) {
                indexV = s.indexOf(romanSymbols[i + 1]);
            }
            if (indexI != -1 || indexV != -1) {
                if (indexI != -1) {
                    index = indexI;
                    if (indexV !=-1){
                        index = Math.min(indexI, indexV);
                    }
                } else {
                   index  = indexV;
                }
            }
            if (index != -1) {
                String sub = s.substring(index);
                if (i == romanSymbols.length - 1) {
                    result = result + romanValues[i] * sub.length();
                } else {
                    if (sub.length() > 1 && romanSymbols[i].equals(sub.substring(0, 1))
                            && romanSymbols[i + 2].equals(sub.substring(1, 2))) {
                        result = result + romanValues[i + 2] - romanValues[i];
                    } else if (romanSymbols[i + 1].equals(sub.substring(0, 1))) {
                        result = result + romanValues[i + 1];
                        result = result + romanValues[i] * (sub.length() - 1);
                    } else if (sub.length() > 1 && romanSymbols[i].equals(sub.substring(0, 1))
                            && romanSymbols[i + 1].equals(sub.substring(1, 2))) {
                        result = result + romanValues[i + 1] - romanValues[i];
                    } else {
                        result = result + romanValues[i] * sub.length();
                    }
                }
            }
            i += 2;
            if (index != -1) {
                s = s.substring(0, index);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
