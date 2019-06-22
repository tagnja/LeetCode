#include <iostream>
#include "ReverseInteger.cpp"

int main()
{
	Solution solution;
	std::cout << solution.reverse(123) << std::endl; // result is 321
	std::cout << solution.reverse(1534236469) << std::endl; // result is 0
	std::cout << solution.reverse(-123) << std::endl; // result is -321
	std::cout << solution.reverse(-2147483412) << std::endl; // result is -2143847412
	std::cout << solution.reverse(-2147483648) << std::endl; // result is 0
	return 0;
}