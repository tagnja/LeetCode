package com.jack.leetcode.easy;

import java.util.ArrayList;
import java.util.List;


/**
Description:
	Write a program that outputs the string representation of numbers from 1 to n.
	But for multiples of three it should output ��Fizz�� instead of the number and for the multiples of five output ��Buzz��. For numbers which are multiples of both three and five output ��FizzBuzz��.
 
Example:
	n = 15,
	
	Return:
	[
	    "1",
	    "2",
	    "Fizz",
	    "4",
	    "Buzz",
	    "Fizz",
	    "7",
	    "8",
	    "Fizz",
	    "Buzz",
	    "11",
	    "Fizz",
	    "13",
	    "14",
	    "FizzBuzz"
	]
	
attention:The number both divide by 3 and 4;
 
 * @author TaogenJia
 *	
 */
public class A412_FizzBuzz {

	public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
        	StringBuffer b = new StringBuffer() ;
            if((i+1)%3==0){
            	b.append("Fizz");
            	//s = "Fizz";
            }
            if((i+1)%5==0){
            	b.append("Buzz");
            	//s += "Buzz";
            }
            if(b.length()==0){
                b.append(String.valueOf(i+1));
            }
            
            list.add(b.toString());
        }
        return list;
    }
}
