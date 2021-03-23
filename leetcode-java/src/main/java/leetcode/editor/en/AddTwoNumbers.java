//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself.
//
//
// Example 1:
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//
//
// Example 2:
//
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//
//
// Example 3:
//
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
//
//
//
// Constraints:
//
//
// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading
// zeros.
//
// Related Topics Linked List Math Recursion
// 👍 11172 👎 2667


package leetcode.editor.en;

import java.util.Arrays;

public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println("example 1");
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = ListNode.constructLinkByArray(
                Arrays.asList(2, 4, 3));
        ListNode l2 = ListNode.constructLinkByArray(
                Arrays.asList(5, 6, 4));
        ListNode.printLink(solution.addTwoNumbers(l1, l2));
        System.out.println("example 2");
        ListNode l21 = ListNode.constructLinkByArray(
                Arrays.asList(9, 9, 9, 9, 9, 9, 9));
        ListNode l22 = ListNode.constructLinkByArray(
                Arrays.asList(9, 9, 9, 9));
        ListNode.printLink(solution.addTwoNumbers(l21, l22));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            /**
             * Note: Must clear what is the definite end loop condition
             * Result:
             * T(n) = O(n), S(n) = O(n)
             * Runtime faster than 77.52%,
             * Memory usage less than 60.8%
             */
            // add two linked list
            ListNode root = new ListNode();
            ListNode current = root;
            int carryNumber = 0;
            while (l1 != null || l2 != null || carryNumber > 0) {
                int sum = 0;
                if (l1 != null) {
                    sum += l1.val;
                }
                if (l2 != null) {
                    sum += l2.val;
                }
                sum += carryNumber;
                int remainder = sum % 10;
                current.next = new ListNode(remainder);
                carryNumber = sum / 10;
                current = current.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            return root.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
