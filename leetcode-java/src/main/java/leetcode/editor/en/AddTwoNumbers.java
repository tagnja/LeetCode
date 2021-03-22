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
        Solution solution = new AddTwoNumbers().new Solution();
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println("example 2");
        Integer a[] = {9, 9, 9, 9, 9, 9, 9};
        Integer b[] = {9, 9, 9, 9};
        ListNode l21 = ListNode.constructLinkByArray(Arrays.asList(a));
        ListNode.printLink(l21);
        ListNode l22 = ListNode.constructLinkByArray(Arrays.asList(b));
        ListNode.printLink(l22);
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
             * Must clear what is the definite end loop condition
             */
            // add two linked list
            ListNode resultLink = new ListNode();
            ListNode root = resultLink;
            int over = 0;
            while (l1 != null || l2 != null || over > 0) {
                int sum = 0;
                if (l1 != null) {
                    sum += l1.val;
                }
                if (l2 != null) {
                    sum += l2.val;
                }
                sum += over;
                int result = sum % 10;
                root.next = new ListNode(result);
                over = sum / 10;
                root = root.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            return resultLink.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
