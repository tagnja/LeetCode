#include <cmath>
#include <climits>
#include <iostream>
#include <cstdlib>

class Solution
{
	public:
		int reverse(int x)
		{
			int result = 0;
			while (x != 0) // when positive and negative isn't signle digital
			{
				int pop = x % 10;
				// overflow check
				if ((pop > 0 && result > (INT_MAX - pop) / 10) || 
					(pop < 0 && result < (INT_MIN - pop)/ 10))
				{
					return 0;
				}
				result = result * 10 + pop; 
				x = x / 10;
			}
			return result;
		}
		
		
};

