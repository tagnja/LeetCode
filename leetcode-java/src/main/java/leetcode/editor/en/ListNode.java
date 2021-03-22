package leetcode.editor.en;

import java.util.Arrays;
import java.util.List;

/**
 * @author Taogen
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode constructLinkByArray(List<Integer> list) {
        if (list == null) {
            return null;
        }
        ListNode root = new ListNode();
        ListNode result = root;
        for (Integer i : list) {
            root.next = new ListNode(i);
            root = root.next;
        }
        return result.next;
    }

    public static void printLink(ListNode root) {
        System.out.print("[ ");
        while (root != null) {
            System.out.print(root.val);
            if (root.next != null) {
                System.out.print(", ");
            }
            root = root.next;
        }
        System.out.println(" ]");
    }
}
