
public class Solution1 {
	
	public static void main(String[] args)
	{
		ListNode n = new ListNode(9);
		ListNode n2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))))))));
		System.out.println(addTwoNumbers(n, n2));
	}
	
	
    public static ListNode reverse(ListNode h)
    {
        ListNode cur = h;
        ListNode prev = null;
        ListNode temp = null;
        while(cur != null)
        {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0;
        int n2 = 0;
        
        ListNode cur = l1;
        while(cur!=null)
        {
            n1 += cur.val;
            n1 *= 10;
            cur = cur.next;
        }
        cur = l2;
        while(cur!=null)
        {
            n2 += cur.val;
            n2 *= 10;
            cur = cur.next;
        }
        n1/=10;
        n2/=10;
        int ans = n1+n2;
        
        ListNode head = null;
        ListNode tail = null;
        while(ans!=0)
        {
            int v = ans%10;
            ans/=10;
            if(head == null)
            {
                head = new ListNode(v);
                tail = head;
            }
            else
            {
                tail.next = new ListNode(v);
                tail = tail.next;
            }
        }
        if(head==null)
            head = new ListNode(0);
        
        return reverse(head);
    }
}

class ListNode 
{
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 public String toString()
	 {
		 String str = "[";
		 ListNode cur = this;
		 while(cur!=null)
		 {
			 str+=cur.val + ", ";
			 cur = cur.next;
		 }
		 str += "]";
		 return str;
	 }
}


