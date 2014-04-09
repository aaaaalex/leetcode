public class Solution {
    public String reverseWords(String s) {
		StringNode head = null;
		StringNode tail = null;

		for(int i = s.length()-1; i >= 0; i--) {
			char currchar = s.charAt(i);
			if(currchar == ' ')
				continue;
			boolean firstchar = true;
			StringNode tmphead = null;
			StringNode tmpcurr = null;
			for(;i >=0; i--)
			{
				currchar = s.charAt(i);
				if(currchar == ' ')
					break;
				StringNode newnode = new StringNode();
				newnode.data = currchar;
				if(tmphead == null)
				{
					tmphead = newnode;
					tmpcurr = newnode;
				} else {
			    	newnode.next = tmphead;
					tmphead = newnode;
				}
			}
			if(head == null) {
				head = tmphead;
				tail = tmpcurr;
			} else {
				StringNode spacenode = new StringNode();
				spacenode.data = ' ';
				tail.next = spacenode;
				tail = spacenode;		
				tail.next = tmphead;
				tail = tmpcurr;
			}
			
		}

		if(head == null)
			return "";

		StringBuilder sb = new StringBuilder();
		StringNode p = head;
		while(p != null)
		{
			sb.append(p.data);
			p = p.next;
		}

		return sb.toString();
	}

	public class StringNode{
		char data;
		StringNode prev;
		StringNode next;
	}
}