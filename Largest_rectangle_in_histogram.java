public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
		Stack<Integer> record = new Stack<Integer> ();
		int max = 0;
		for(int i = 0; i < height.length; i++)
		{
			if(record.empty() || height[i] > height[record.peek()])
			{
				record.push(i);
			}
			else
			{
				int start = record.pop();
				int width = record.empty()? i : i-record.peek() - 1;
				max = Math.max(max, height[start] * width);
				i--;
			}
		}
		
		while(!record.empty())
		{
			int start = record.pop();
			int h = height[start];
			int width = (record.empty()) ? height.length: height.length - record.peek() - 1;
			max = Math.max(max, width * h);
		}
		
		return max;
    }
}