#include <climits>
#include <string>
using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        int i = 0, len = str.length(), flagNo = -1, numberNo = -1, invalidNo = -1;
		bool isPositive = true;
        for (i = 0; i < len; i++)
        {
            if (str[i] == ' ')
            {
            }
            else if (str[i] == '-' || str[i] == '+')
            {
                if (flagNo == -1)
                    flagNo = i;
            }
            else if (isNumber(str[i]))
            {
                if (numberNo == -1)
                    numberNo = i;
            }
            else
            {
                if (invalidNo == -1)
                    invalidNo = i;
            }
        }
		// is invalid
        if (numberNo == -1 || (numberNo > -1 && invalidNo > -1 && invalidNo < numberNo))
        {
            return 0;
        }
		
		if (numberNo > -1 && flagNo > -1 && numberNo - flagNo > 1)
		{
			return 0;
		}
		
		// is positive
		if (numberNo > -1 && flagNo > -1 && numberNo - flagNo == 1)
		{
			if (str[flagNo] == '-')
				isPositive = false;
		}
		
		// get number string
        for (i = numberNo + 1; i < len; i++)
        {
            if (! isNumber(str[i]))
            {
                break;
            }
        }
		int numberEnd = i;
        
		int numberBegin = numberNo;
        for (i = numberBegin; i < numberEnd; i++)
        {
            if (str[i] != '0')
            {
                break;
            }
        }
        if (i == numberEnd)
        {
            numberBegin = i - 1;
        }
        else
        {
            numberBegin = i;
        }
		
        string numberStr = str.substr(numberBegin, numberEnd - numberBegin);
		
		// convert to int, and check overflow
		int result = 0;
		int flag = isPositive ? 1 : -1;
		for (int i = 0; i < numberStr.length(); i++)
		{
			int pop = (numberStr[i] - '0') * flag;
			if ((isPositive && result > (INT_MAX - pop) / 10))
			{
				return INT_MAX;
			}
			
			if (! isPositive && result < (INT_MIN - pop) / 10)
			{
				return INT_MIN;
			}
			result = result * 10 + pop;
		}
		
		return result;
    }
    
    bool isNumber(char c)
    {
        char nums[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i, len = sizeof(nums) / sizeof(nums[0]);
        for (i = 0; i < len; i++)
        {
            if (c == nums[i])
            {
                break;
            }
        }
        if (i < len && i >= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
};