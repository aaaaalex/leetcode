public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> buffer = new Stack<String> ();
        int res = 0;
        for(int i = 0; i < tokens.length; i++)
        {
            if(isNum(tokens[i])) {
                buffer.push(tokens[i]);
            } else {
                String num1 = buffer.pop();
                String num2 = buffer.pop();
                String tmpres = "";
                if(tokens[i] == null)
                    continue;
                if(tokens[i].equals("+")) {
                    int n1 = Integer.parseInt(num1);
                    int n2 = Integer.parseInt(num2);
                    int tmpresnum = n2+n1;
                    tmpres = String.valueOf(tmpresnum);
                } else if(tokens[i].equals("-")) {
                    int n1 = Integer.parseInt(num1);
                    int n2 = Integer.parseInt(num2);
                    int tmpresnum = n2-n1;
                    tmpres = String.valueOf(tmpresnum);
                } else if(tokens[i].equals("*")) {
                    int n1 = Integer.parseInt(num1);
                    int n2 = Integer.parseInt(num2);
                    int tmpresnum = n2*n1;
                    tmpres = String.valueOf(tmpresnum);
                } else if(tokens[i].equals("/")) {
                    int n1 = Integer.parseInt(num1);
                    int n2 = Integer.parseInt(num2);
                    int tmpresnum = n2/n1;
                    tmpres = String.valueOf(tmpresnum);
                } else {
                    continue;
                }
                
                buffer.push(tmpres);
            }
        }
        if(buffer.size() > 0) {
            String resStr = buffer.pop();
            res = Integer.parseInt(resStr);
        }
        return res;
    }
    
    private boolean isNum(String s)
    {
        if(s == null || s.length() == 0)
            return false;
        if(s.length() > 1)
            return true;
        char tmp = s.charAt(0);
        if(tmp >= '0' && tmp <= '9')
            return true;
        return false;
    }
}