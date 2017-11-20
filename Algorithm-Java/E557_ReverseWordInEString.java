package com.jack.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
  Reverse Words in a String III
  Description
  	Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
  Example 1:
	  Input: "Let's take LeetCode contest"
	  Output: "s'teL ekat edoCteeL tsetnoc"
  Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class A557_ReverseWordInAString {
	/**
	 * solve
	 * 如何拆分，单个单词取反，整合
	 * (1)拆分，以空格拆分保存到list中。String target = s.substring(0,s.indexOf(" "))
	 * (2)取反a[i] = a[(size-1)-i], i = 0~n/2
	 * (3)整合String s = s + list.get(i)+" ";
	 * String s = list[i]+space  
	 * result:13%
	 */
	public String reverseWords(String s){
		if(s!=null&&!"".equals(s.trim())){
			//拆分
			List<String> list = new LinkedList<String>();
			while(s.indexOf(" ")>=0){
				String word = s.substring(0, s.indexOf(" "));
				//System.out.println("index-1:"+s.charAt(s.indexOf(" ")-1)+"，word:"+word);
				list.add(word);
				s = s.substring(s.indexOf(" ")+1, s.length());
			}
			list.add(s);
			/*System.out.println("拆分List："+list.toString());
			System.out.println("-----------------------------------");*/
			//取反
			for(int i = 0; i<list.size(); i++){
				char[] c = list.get(i).toCharArray();
				for(int j = 0; j<=(c.length-1)/2; j++){
					char temp = c[j];
					c[j] = c[c.length-1-j];
					c[c.length-1-j] = temp;
				}
				list.set(i, new String(c));
			}
			//System.out.println("取反List："+list.toString());
			//整合
			s = "";
			for(int k=0; k<list.size()-1; k++){
				s = s + list.get(k)+" ";
			}
			s = s + list.get(list.size()-1); 
			return s;
		}else
			return "";
	}
	
	/**
	 * 优化
	 * (1)拆分利用split(String regex)
	 * result：10%
	 */
	public String reverseWords02(String s){
		if(s!=null&&!"".equals(s.trim())){
			//拆分
			String[] s2 = s.split("\\ ");
			//System.out.println("String[] length:"+s2.length);
			//取反
			for(int i = 0; i<s2.length; i++){
				char[] c = s2[i].toCharArray();
				for(int j = 0; j<=(c.length-1)/2; j++){
					char temp = c[j];
					c[j] = c[c.length-1-j];
					c[c.length-1-j] = temp;
				}
				s2[i] = new String(c);
			}
			//System.out.println(s2[0]);
			//整合
			String s3 = "";
			for(int k=0; k<s2.length-1; k++){
				s3 = s3 + s2[k]+ " ";
			}
			return s3+s2[s2.length-1];
		}else
			return "";
	}
	
	/**
	 * 他人作品01
	 */
	public String reverseWords_A(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {   // when i is a non-space
                int j = i;
                while (j + 1 < ca.length && ca[j + 1] != ' ') { j++; } // move j to the end of the word
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }
    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
    
    /**
     * 他人作品02
     */
    public String reverseWords_B(String s) {
        String[] strs = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(String str: strs){
            StringBuffer temp = new StringBuffer(str);
            sb.append(temp.reverse());
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
	@Test
	public void test(){
		//test01
		String s = "hello world i'm jiataogen";
		s = reverseWords02(s);
		System.out.println("result:"+s);
		//test02
		String s2 = "hello";
		s2 = reverseWords02(s2);
		System.out.println("result:"+s2);
		//test03
		String s3 = "";
		s3 = reverseWords02(s3);
		System.out.println("result:"+s3);
		
	}
	
}
