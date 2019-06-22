#include <iostream>
#include "ZigZagConversion.cpp"

int main()
{
	Solution solution;
	std::string s = "PAYPALISHIRING";
	int numRows = 3;
	std::cout << "convert result is " << solution.convert(s, numRows);
	return 0;
}