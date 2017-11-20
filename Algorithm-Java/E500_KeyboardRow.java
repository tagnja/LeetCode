package com.jack.leetcode.easy;

import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author jiatg
 * # Description
 * Given a List of words, 
 * return the words that can be typed using letters of alphabet 
 * on only one row's of American keyboard like the image below.
 * 
 * # Example
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * 
 */
public class A500_KeyboardRow {
	/**
	 * 自己初始，Runtime-16%
	 * @param words
	 * @return
	 */
	public String[] findWords(String[] words) {
        String[] target = new String[words.length];
        int count = 0;
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        for(int i = 0; i<words.length; i++){
        	if(s1.contains(words[i].toLowerCase().charAt(0)+"")){
        		if(words[i].length()>1){
	        		for(int j = 1; j<words[i].length(); j++){
	        			if(!s1.contains(words[i].toLowerCase().charAt(j)+"")){
	        				target[i] = "false";
	        				break;
	        			}else  if(j == (words[i].length()-1)){
	        				target[i] = words[i];
	        				count++;
	        			}
	        		}
        		}else{
        			target[i] = words[i];
    				count++;
        		}
        	}else if(s2.contains(words[i].toLowerCase().charAt(0)+"")){
        		if(words[i].length()>1){
	        		for(int j = 1; j<words[i].length(); j++){
	        			if(!s2.contains(words[i].toLowerCase().charAt(j)+"")){
	        				target[i] = "false";
	        				break;
	        			}else  if(j == (words[i].length()-1)){
	        				target[i] = words[i];
	        				count++;
	        			}
	        		}
        		}else{
	        			target[i] = words[i];
	    				count++;
        		}
        	}else if(s3.contains(words[i].toLowerCase().charAt(0)+"")){
        		if(words[i].length()>1){
	        		for(int j = 1; j<words[i].length(); j++){
	        			if(!s3.contains(words[i].toLowerCase().charAt(j)+"")){
	        				target[i] = "false";
	        				break;
	        			}else if(j == (words[i].length()-1)){
	        				target[i] = words[i];
	        				count++;
	        			}
	        		}
        		}else{
        			target[i] = words[i];
    				count++;
        		}
        	}
        }
        System.out.println("count:"+count);
        String[] result = new String[count];
        int count2 = 0;
        for(int k = 0; k < words.length; k++){
        	if(!"false".equals(target[k])){
        		result[count2] = target[k];
        		count2++;
        	}
        }
        return result;
    }
	/**
	 * 自己优化后，Runtime-80%
	 * @param words
	 * @return
	 */
	public String[] findWords02(String[] words) {
        int count = 0;
        String[] key = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        for(int i = 0; i<words.length; i++){
        	String word = words[i].toLowerCase();
        	for(int j = 0; j<=2; j++){
	        	if(key[j].contains(word.charAt(0)+"")){
	        		if(words[i].length()>1){
		        		for(int k = 1; k<words[i].length(); k++){
		        			if(!key[j].contains(word.charAt(k)+"")){
		        				words[i] = "false";
		        				break;
		        			}else if(k == (words[i].length()-1))
		        				count++;
		        		}
	        		}else
	    				count++;
	        	}
        	}
        }
        String[] result = new String[count];
        count = 0;
        for(int k = 0; k < words.length; k++){
        	if(!"false".equals(words[k])){
        		result[count] = words[k];
        		count++;
        	}
        }
        return result;
    }
	/**
	 * Runtime-2%
	 * @param words
	 * @return
	 */
	public String[] findWords666(String[] words) {
		return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
	}
	@Test
	public void test1(){
		/*
		String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
		 */
		//test case
		String[] s1 = {"Hello", "Alaska", "Dad", "Peace"};
		String[] s2 = {"a","b"};
		String[] s3 = {"Aasdfghjkl","Qwertyuiop","zZxcvbnm"};
		
		//print result
		String[] result = findWords666(s1);
		for(String ss : result)
			System.out.println(ss);
	}
}
