package com.jack.leetcode.easy;

import java.util.ArrayList;

/**
Description
You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.

Example 1:
Input: ["5","2","C","D","+"]
Output: 30
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get 2 points. The sum is: 7.
Operation 1: The round 2's data was invalid. The sum is: 5.  
Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
Example 2:
Input: ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get -2 points. The sum is: 3.
Round 3: You could get 4 points. The sum is: 7.
Operation 1: The round 3's data is invalid. The sum is: 3.  
Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
Round 5: You could get 9 points. The sum is: 8.
Round 6: You could get -4 + 9 = 5 points. The sum is 13.
Round 7: You could get 9 + 5 = 14 points. The sum is 27.
Note:
The size of the input list will be between 1 and 1000.
Every integer represented in the list will be between -30000 and 30000.
 * @author jiatg
 *
 */
public class A682_BaseballGame {

	public static void main(String[] args){
		String[] s = {"5","2","C","D","+"};
		String[] s2 = {"5","-2","4","C","D","9","+","+"};
		String[] s3 = {"-60","D","-36","30","13","C","C","-33","53","79"};
		System.out.println("result:"+calPoints_1(s3));
	}
	/**
	 * Accept：第2次通过，beats 26%.
	 * 测试数据：
	 * {"-60","D(-180)","-36(-216)","30(-186)","13"(-173),"C"(-186),"C"(-216),"-33(-249)","53"(-196),"79"(-117)};
	 */
	public static int calPoints(String[] ops) {
		int sum = 0;
		for(int i = 0; i < ops.length; i++){
			if("C".equals(ops[i])){
				ops[i] = null;
				int lastValidIndex = -1 ; 
				for(int j = i-1; j >= 0; j--)
					if(ops[j]!=null){
						lastValidIndex = j;
						break;
					}
				if(lastValidIndex>=0){
					sum -= Integer.parseInt(ops[lastValidIndex]);
					ops[lastValidIndex] = null;
				}
			}else{
				if("D".equals(ops[i])){
					for(int j = i-1; j >= 0; j--)
						if(ops[j]!=null){
							ops[i] = String.valueOf(Integer.parseInt(ops[j]) * 2);
							break;
						}
				}
				if("+".equals(ops[i])){
					int firstIndex = 0,secondIndex = 0;
					for(int j = i-1; j >= 0; j--)
						if(ops[j]!=null){
							firstIndex = j;
							break;
						}
					for(int j = firstIndex-1; j >= 0; j--)
						if(ops[j]!=null){
							secondIndex = j;
							break;
						}
					ops[i] = String.valueOf(Integer.parseInt(ops[firstIndex])+Integer.parseInt(ops[secondIndex]));
				}
				sum += Integer.parseInt(ops[i]);
			}
		}
        return sum;
    }
	/**
	 * 尝试优化1
	 * Accept：第1次提交通过，beats 46%.
	 * 测试数据：{"-60","D(-180)","-36(-216)","30(-186)","13"(-173),"C"(-186),"C"(-216),"-33(-249)","53"(-196),"79"(-117)};
	 */
	public static int calPoints_1(String[] ops) {
		int sum = 0;
		for(int i = 0; i < ops.length; i++){
			if("C".equals(ops[i])){
				int j = i - 1;
				for(; j >= 0; j--)
					if(!"C".equals(ops[j]))
						break;
				sum -= Integer.parseInt(ops[j]);
				ops[j] = "C";
			}
			else{
				if("D".equals(ops[i])){
					int j = i - 1;
					for(;j >= 0; j--)
						if(!"C".equals(ops[j])){
							ops[i] = String.valueOf(Integer.parseInt(ops[j]) * 2);
							break;
						}
				}
				if("+".equals(ops[i])){
					int j = i - 1, count = 0, result = 0;
					for(;j >= 0; j--)
						if(!"C".equals(ops[j])){
							count ++;
							if(count > 2)
								break;
							result += Integer.parseInt(ops[j]);
						}
					ops[i] = String.valueOf(result);
				}
				sum += Integer.valueOf(ops[i]);
			}
		}
		return sum ;
	}
	
}
