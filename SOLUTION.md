# LeetCode Solution Tips



**Algorithms**

| #    | Title                                          | Solutions                                                    | Difficulty | Tags          | Tips & Notices                                               |
| ---- | ---------------------------------------------- | ------------------------------------------------------------ | ---------- | ------------- | ------------------------------------------------------------ |
| 8    | String to Integer                              | [cpp](algorithms/cpp/0008-StringToInteger/StringToInteger.cpp) | Medium     | `#string`     | Notice: Input string type is too many and  judgement is difficult. |
| 7    | Reverse Integer                                | [cpp](algorithms/cpp/0007-ReverseInteger/ReverseInteger.cpp) | Easy       | `#number`     | Notice: (1)number overflow detection. Convert * to /. (2) Positive and negative max value is not equal. Can't use abs(x) < max_val to judge overflow. |
| 6    | ZigZag Conversion                              | [cpp](algorithms/cpp/0006-ZigZagConversion/ZigZagConversion.cpp) | Medium     | `#string`     | String handle                                                |
| 5    | Longest Palindromic Substring                  | [Java](algorithms/java/5LongestPalindromicSubstring/LongestPalindromicSubstring.java) | Medium     | `#enum`       |                                                              |
| 3    | Longest Substring Without Repeating Characters | [Java](algorithms/java/3LongestSubstringWithoutRepeatingCharacters/LongestSubstringWithoutRepeatingCharacters.java) | Medium     | `#DP`         | Tips: Using assisted mark array like Longest Increase Subsequence. |
| 2    | Add Two Numbers                                | [Java](algorithms/java/2AddTwoNumbers/AddTwoNumbers.java)    | Medium     | `#linkedlist` | Notices: (1) Notice the Linked List Node cycle assignment. (2) Situation classify need clear. (3) Multiple condition while using \|\| instead of && can more concise. |
| 1    | Two Sum                                        | TO REDO                                                      | Easy       | `#number`     | Tips: HashMap can find O(1). try O(n^2) -> O(n)              |



### Number Skills

Reverse Integer

Approach: **Pop and Push Digits & Check before Overflow**

Push Digits

(x1 * 10 + x2) * 10 + x3 => x1x2x3

(1 * 10 + 2) * 10 + 3 => 123

result = result * 10 + pop

```
// Pop operation
pop = x % 10;
x /= 10;

// push operation
result = result * 10 + pop

// overflow check
if ((pop > 0 && result > (INT_MAX - pop) / 10) || 
	(pop < 0 && result < (INT_MIN - pop)/ 10))
{
return 0;
}
```

