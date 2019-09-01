#include <limits.h>
class Solution {
public:
    // INT_MAX error, <= error 10, logic 123123
    bool isPalindrome(int x) {
        if (x < 0)
        {
            return false;
        }
        int i = 1;
        int flag = 10;
        while (x >= flag)
        {
            i++;
            if (flag < INT_MAX / 10)
            {
                flag *= 10;
            }
            else
            {
                break;
            }
        }
        int a[i];
        
        int j = 0;
        for (; j < i; j++)
        {
            a[j] = x % 10;
            x = x / 10;
        }
        for (j = 0; j < i/2; j++)
        {
            if (a[j] != a[i - j - 1])
            {
                break;
            }
        }
        return j >= i/2;
    }
    
};