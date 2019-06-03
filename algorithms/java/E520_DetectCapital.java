package com.jack.leetcode.easy;

import org.junit.Test;

public class A520_DetectCapital {
	/**
	 * 方法1：使用字符串遍历方法
	 * runtime:O(n) = n, 17%
	 * @param word
	 * @return
	 */
	public boolean detectCapitalUse(String word) {
        char head = word.charAt(0);
        int i = 0;
        boolean isUpper = false, isLower = false;
        if(word.length()==1)
            return true;
        else{
            if(word.charAt(0) <= 90){
                for(i = 1; i < word.length(); i++){
                    if(word.charAt(i) <= 90)
                        isUpper = true;
                    if(word.charAt(i) >= 97)
                        isLower = true;
                }
                if(isUpper && isLower)
                    return false;
                else
                    return true;
            }else{
                for(i = 1; i < word.length(); i++){
                    if(word.charAt(i) <= 90)
                        break;
                }
                System.out.println("i:"+i);
                if(i == word.length())
                    return true;
                else
                    return false;
            }
        }
    }
	
	/**
	 * 方法2：使用正则表达式
	 * @param word
	 * @return
	 */
	public boolean detectCapitalUse2(String word) {
			//return word.matches("[A-Z][A-Z]*|[A-Z][a-z]*|[a-z][a-z]*");
			return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	}
	@Test
	public void test01(){
		System.out.println(detectCapitalUse2("a"));
		System.out.println(detectCapitalUse2("abc"));
		System.out.println(detectCapitalUse2("abC"));
		System.out.println(detectCapitalUse2("A"));
		System.out.println(detectCapitalUse2("AbC"));
		System.out.println(detectCapitalUse2("Abc"));
		System.out.println(detectCapitalUse2("ABC"));
	}
	/*****************************************/
	/**
	 * 其他解答01
	 * 很好的遍历字符串的方法，比我的遍历过程好。把问题转移为有几个大写字母，避免复杂的分类讨论。
	 * 0个大写字母，则return true。
	 * 1个大写字母，判断是否是首字母。
	 * 大于1个大写字母，判断是否全是大写字母。
	 */
	public boolean detectCapitalUse01(String word) {
        int numUpper = 0;
        for (int i=0;i<word.length();i++)
            if (Character.isUpperCase(word.charAt(i))) numUpper++;
        if (numUpper == 1) return Character.isUpperCase(word.charAt(0));
        return numUpper == 0 || numUpper == word.length();
    }

}
