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
			
			if (x > INT_MAX || x < INT_MIN)
			{
				return 0;
			}
			if ((x >= 0 && x < 10) || (x < 0 && x > -10))
			{
				return x;
			}
			
			int i = 0;
			for (; i < 32; i++)
			{
				int num = getPow(i + 1);
				if ((x > 0 && x / num < 10) || (x < 0 && x / num > -10))
				{
					break;
				}
			}
			
			int count = i+2;
			
			for (int i = 0; i < count; i++)
			{
				int num = getPow(count - i - 1);
				if (i == 9)
				{
					if ((x > 0 && x/num > (INT_MAX - result) / getPow(i)) || 
						(x < 0 && x/num < (INT_MIN -result) / getPow(i)))
					{
						result = 0;
						break;
					}
				}
				result += x / num * getPow(i);
				x = x % num;
			}
			return result;
		}
		
		int getPow(int i)
		{
			int num = 1;
			for (int j = 0; j < i; j++)
			{
				num *= 10;
			}
			return num;
		}
};