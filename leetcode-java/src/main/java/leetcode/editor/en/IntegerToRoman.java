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
// Given an integer, convert it to a roman numeral.
//
//
// Example 1:
//
//
//Input: num = 3
//Output: "III"
//Explanation: 3 is represented as 3 ones.
//
//
// Example 2:
//
//
//Input: num = 58
//Output: "LVIII"
//Explanation: L = 50, V = 5, III = 3.
//
//
// Example 3:
//
//
//Input: num = 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//
//
//
// Constraints:
//
//
// 1 <= num <= 3999
//
// Related Topics Hash Table Math String 👍 2603 👎 3704


package leetcode.editor.en;
public class IntegerToRoman{
  public static void main(String[] args) {
       Solution solution = new IntegerToRoman().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String intToRoman(int num) {
        //I(1), V(5), X(10), L(50), C(100), D(500) and M(1000).
        // 0, 1~3, 4, 5~8, 9,
        StringBuilder sb = new StringBuilder();
        String[] romanSymbols = {"I", "V", "X", "L", "C", "D", "M"};
        int[] romanValues = {1, 5, 10, 50, 100, 500, 1000};
        int i = 6;
        int divisor = romanValues[i];
        while (num % divisor != 0 || i >= 0) {
            int quotient = num / divisor;
            if (quotient == 9) {
                sb.append(romanSymbols[i]).append(romanSymbols[i + 2]);
            } else if (quotient < 9 && quotient >= 5) {
                sb.append(romanSymbols[i + 1]);
                for (int j = 0; j < quotient - 5; j++) {
                    sb.append(romanSymbols[i]);
                }
            } else if (quotient == 4) {
                sb.append(romanSymbols[i]);
                sb.append(romanSymbols[i + 1]);
            } else if (quotient > 0 && quotient < 4) {
                for (int j = 0; j < quotient; j++) {
                    sb.append(romanSymbols[i]);
                }
            }
            num = num % divisor;
            i = i - 2;
            if (i >= 0) {
                divisor = romanValues[i];
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
