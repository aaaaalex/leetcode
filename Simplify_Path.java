public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
		Stack<String> records = new Stack<String> ();
		if(path.length() == 1)
			return path;
		
		int i = 0;
		while(i < path.length())
		{
			if(path.charAt(i) == '/')
			{
				while(i < path.length() && path.charAt(i) == '/')
				{
					i++;
				}
			}
			if(i == path.length())
			{
				break;
			}
			
			String currpart = "";
			while(i < path.length() && path.charAt(i) != '/')
			{
				currpart += Character.toString(path.charAt(i));
				i++;
			}
			if(currpart.equals("."))
				continue;
			if(currpart.equals(".."))
			{
				if(!records.empty())
				{
					records.pop();
				}
				continue;
			}
			records.push(currpart);
		}
		
		if(records.empty())
			return "/";
		
		String res = "";
		
		while(!records.empty())
		{
			res = "/"+records.pop()+res;
		}
		return res;
    }
}