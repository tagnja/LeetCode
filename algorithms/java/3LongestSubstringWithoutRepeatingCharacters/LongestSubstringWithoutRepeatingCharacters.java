class LongestSubstringWithoutRepeatingCharacters 
{
	
	/**
	 * T(n) = O(n^2);
	 */
	public static int lengthOfLongestSubstring(String s) 
    {   
		// My Submit Fail Records.
		// Wrong Answer 1: Input "bbb", Output 0, Expected 1.
		// Wrong Answer 2: Input "", Output 1, Expected 0.
		// Wrong Answer 3: Input " ", Output 0, Expected 1.
		// Wrong Answer 4: Input "bpfbhmipx", Output 6, Expected 7.
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        
        int max = 1, len = s.length();
        int[] flag = new int[len];
        char[] arr = s.toCharArray();
        
        // initial flag array
        for (int i = 0; i < len; i++)
        {
            flag[i] = 1;
        }
        
        int begin = 0, i = 0, j = 0;
        for (i = 1; i < len; i++)
        {
            for (j = begin; j < i; j++)
            {
                if (arr[i] == arr[j])
                {
                    flag[i] = i - j; 
                    begin = j + 1;
                    break;                    
                }
            }
            if (j == i)
            {
                flag[i] = flag[i-1] + 1;
                
            }
            if (flag[i] > max)
            {
                max = flag[i];
            }
        }
        return max;
    }
	
	public static void main(String[] args)
	{
		System.out.println("\"bbb\" expected 1 : " + lengthOfLongestSubstring("bbb"));
		System.out.println("\"\" expected 0 : " + lengthOfLongestSubstring(""));
		System.out.println("\" \" expected 1 : " + lengthOfLongestSubstring(" "));
		System.out.println("\"bpfbhmipx\" expected 7 : " + lengthOfLongestSubstring("bpfbhmipx"));		
	}
}