
public class AddTwoNumbers
{

	/**
     Wrong Answer 1: intput [5], [5], output [0], expected [0, 1]
     Wrong Answer 2: input [9, 8], [1], output [0, 1], expected [0, 9]
     Wrong Answer 3: input [1], [9, 9], output[0, 10], expected [0, 0, 1]
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
        int forward = 0;
        ListNode node = new ListNode(0);
        ListNode root = node;
        while (l1 != null && l2 != null)
        {
            node.next = new ListNode((l1.val + l2.val + forward) % 10 );
            forward = (l1.val + l2.val + forward) / 10;
            l1 = l1.next; 
            l2 = l2.next;
            node = node.next;
        }
        
        while (l1 != null)
        {
            node.next = new ListNode((l1.val + forward) % 10);
            forward = (l1.val + forward) / 10;
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null)
        {
            node.next = new ListNode((l2.val + forward) % 10);
            forward = (l2.val + forward) / 10;
            l2 = l2.next;
            node = node.next;
        }
        if (l1 == null && l2 == null && forward != 0)
        {
            node.next = new ListNode(forward);
            node = node.next;
        }
        return root.next;
    }
	public static void main(String[] args)
	{
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		ListNode result = addTwoNumbers(l1, l2);
		while (result != null)
		{
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}