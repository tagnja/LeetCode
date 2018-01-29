package com.jack.leetcode.easy;

import org.junit.Test;

/**
 * @author jiatg
 *	求一个32位正整数去源码高位的0后，对应反码的值，没有前面的0和符号位。
 *	如，5--... 0000 0101--101，反码结果为010=2.
 *	2147483645 -- 0 1111111111111111111111111111101--1111111111111111111111111111101,反码结果=2
 */
public class A476_NumberComplement {

	public int findComplement(int num) {
		//求反码
		num = num ^ 0x7fFFFFFF;
		char[] c = Integer.toBinaryString(num).toCharArray();
		
		if(c.length == 31){
			//截取
			for(int i = 0; i<c.length; i++){
				if(i!=c.length-1 && c[i]=='1'){
					c[i]='0';
				}else{
					break;
				}
			}
			//截取后的二进制转换为十进制
			String s2 = new String(c);
			int result = Integer.parseInt(s2,2);
			return result;
		}else
			return num ;
    }
	@Test
	public void test1(){
		/*
		 * 5          -- 0 0000000000000000000000000000101
		 * 2147483645 -- 0 1111111111111111111111111111101
		 * 2147483646 -- 0 1111111111111111111111111111110
		 * 
		 * 异或后的结果：
		 * 5          -- (0) 1111111111111111111111111111010
		 * 2147483645 -- (0) 10
		 * 2147483646 -- (0) 1
		 * 如果整数的二进制是31位字符串的话，去源码0的反码为：异或后的结果
		 * 如果整数的二进制是小于31位字符串的话，去源码0的反码为：异或后的结果需要去除源码高位无效的0异或形成的的1，
		 */
		System.out.println(Integer.toBinaryString(2147483645^0x7fFFFFFF));
		System.out.println(Integer.toBinaryString(5^0x7fFFFFFF));///000000 00000010
		System.out.println("test:"+findComplement(2147483645));
		System.out.println("test:"+findComplement(2147483646));
		System.out.println("test:"+findComplement(5));
	}
	/*
	 * 十进制 to 二进制，Integer.toBinaryString(int a)
	 * 十进制 to 八进制，Integer.toOctalString(int a)
	 * 十进制 to 十六进制，Integer.toHexString(int a)
	 * 
	 * 二进制 to 十进制，Integer.parseInt(String binaryStr,2);
	 */
}
