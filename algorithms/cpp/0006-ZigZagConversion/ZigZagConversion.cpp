
class Solution
{
	public: 
		std::string convert(std::string s, int numRows)
		{
			if (numRows == 1)
			{
				return s;
			}
			std::string result;
			std::string str[numRows];
			int add = 1;
			for (int i = 0, j = 0; i < s.length(); i++)
			{
				str[j] += s[i];
				if (j == 0)
				{
					add = 1;
				}
				if (j == (numRows - 1))
				{
					add = -1;
				}
				j += add;
			}
			for (int i = 0; i < numRows; i++)
			{
				result += str[i];
			}
			return result;
		}
};