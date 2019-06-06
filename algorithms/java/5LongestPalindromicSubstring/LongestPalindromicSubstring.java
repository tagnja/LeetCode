public class LongestPalindromicSubstring{
	
	/**
	 * T(n) = O(n^2)
	 */
	public static String longestPalindrome(String s) {
        // My Failed Submit Record
        // Wrong Answer: Input "", Output null, Expected ""
        // Wrong Answer2: Input "abcda", Output "bcd", Expected "a"
        if (s == null)
        {
            return null;
        }
        if (s.length() == 0 || s.length() == 1)
        {
            return s;
        }
		
        char[] arr = s.toCharArray();
        int len = s.length();
        int max = 1, p = 0;
        int i = 0, x = 0, y = 0, temp1 = 0, temp2 = 1;
		
        for (i = 1; i < len; i++)
        {
            temp1 = 0;
            temp2 = 1;
			
			// condition 1: abba
            x = i - 1; 
            y = i;
            while (x >= 0 && y < len)
            {
                if (arr[x] != arr[y])
                {
                    break;
                }
                temp1 += 2;
                x--; y++;
            }
			
			// condition 2: abcba
            x = i - 1;
            y = i + 1;
            while (x >= 0 && y < len)
            {
                if (arr[x] != arr[y])
                {
                    break;
                }
                temp2 += 2;
                x--; y++;
            }
			
            temp1 = temp1 > temp2 ? temp1 : temp2;
            if (temp1 > max)
            {
                max = temp1;
                p = i;
            }
        }
		
		// get return String
        if (max % 2 == 0)
        {
            return s.substring(p - max/2, p + max/2);
        }
        else
        {
            return s.substring(p - max/2, p + max/2 + 1);
        }
    }
	
	public static void main(String[] args)
	{
		System.out.println("\"\" expected \"\" : " + longestPalindrome(""));
		System.out.println("\"abcda\" expected \"a\" : " + longestPalindrome("abcda"));
		System.out.println("\"aaabba\" expected \"abba\" : " + longestPalindrome("aaabba"));
	}
}