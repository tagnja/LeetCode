#include <limits.h>
class Solution {
public:
    // INT_MAX error, <= error 10, logic 123123
	bool isPalindrome(int x) {
        if (x < 0)
        {
            return false;
        }
        return (x == getReverseNumber(x));
    }
    
    int getReverseNumber(int x)
	{
		int reverse = 0;
		while (x > 0)
		{
			if (reverse <= (INT_MAX - x % 10) / 10 )
			{
				reverse = reverse * 10 + x % 10;
			}
			else
			{
				return -1;
			}
			x /= 10;
		}
		return reverse;
	}
    
};