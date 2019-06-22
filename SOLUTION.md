# LeetCode Solution Tips



**Algorithms**

| #    | Title                                          | Solutions                                                    | Difficulty | Tags          | Tips & Notices                                               |
| ---- | ---------------------------------------------- | ------------------------------------------------------------ | ---------- | ------------- | ------------------------------------------------------------ |
| 7    | Reverse Integer                                | [cpp](algorithms/cpp/0007-ReverseInteger/ReverseInteger.cpp) | Easy       | `#number`     | Notice: (1)number overflow judgement. Convert * to /. (2) Positive and negative max value is not equal. Can't use abs(x) < max_val to judge overflow. |
| 6    | ZigZag Conversion                              | [cpp](algorithms/cpp/0006-ZigZagConversion/ZigZagConversion.cpp) | Medium     | `#string`     | String handle                                                |
| 5    | Longest Palindromic Substring                  | [Java](algorithms/java/5LongestPalindromicSubstring/LongestPalindromicSubstring.java) | Medium     | `#enum`       |                                                              |
| 3    | Longest Substring Without Repeating Characters | [Java](algorithms/java/3LongestSubstringWithoutRepeatingCharacters/LongestSubstringWithoutRepeatingCharacters.java) | Medium     | `#DP`         | Tips: Using assisted mark array like Longest Increase Subsequence. |
| 2    | Add Two Numbers                                | [Java](algorithms/java/2AddTwoNumbers/AddTwoNumbers.java)    | Medium     | `#linkedlist` | Notices: (1) Notice the Linked List Node cycle assignment. (2) Situation classify need clear. (3) Multiple condition while using \|\| instead of && can more concise. |
| 1    | Two Sum                                        | TO REDO                                                      | Easy       | `#number`     | Tips: HashMap can find O(1). try O(n^2) -> O(n)              |