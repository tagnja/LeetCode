#include <iostream>
#include "StringToInteger.cpp"
using namespace std;

int main()
{
	Solution solution;
	cout << "input is 42, output is " << solution.myAtoi("42") << endl; // expect 42
	cout << "input is    -42, output is " << solution.myAtoi("   -42") << endl; // expect -42
	cout << "input is 4193 with words, output is " << solution.myAtoi("4193 with words") << endl; // expect 4193
	cout << "input is words and 987, output is " << solution.myAtoi("words and 987") << endl; // expect 0
	cout << "input is -91283472332, output is " << solution.myAtoi("-91283472332") << endl; // expect INT_MIN
	cout << "input is   00000  , output is " << solution.myAtoi("  00000  ") << endl; // expect 0
	cout << "input is +1, output is " << solution.myAtoi("+1") << endl;  // expect 1
	cout << "input is   +1  , output is " << solution.myAtoi("  +1  ") << endl; // expect 1
	cout << "input is -1, output is " << solution.myAtoi("-1") << endl; // expect -1
	cout << "input is +-2, output is " << solution.myAtoi("+-2") << endl; // expect 0

	return 0;
}