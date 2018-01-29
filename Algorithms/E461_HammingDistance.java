package com.jack.leetcode.easy;

import org.junit.Test;

/**
 * @author jiatg
 * 汉明距离
 * question:
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Input: x = 1, y = 4
 * Output: 2
 * 1(0 0 0 1) 
 * 4(0 1 0 0)
 * 两个bit对应的数字不同，所以结果为2.
 */
public class A461_HammingDistance {
	/**
	 * Test01
	 * 解决：
	 * 两个数异或，对应的位数字不同结果为1数字相同为0。
	 * 将异或后的整数转换为二进制String，使用String的方法计算String中1出现的次数。
	 * 20%
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance(int x, int y) {
        String s = Integer.toBinaryString(x ^ y);
        boolean flag = true;
        int count = 0;
        while(flag){
            if(s.indexOf("1")!=-1){
                s = s.substring(s.indexOf("1")+1,s.length());
                count ++;
            }else{
                flag = false;
            }
        }
        return count;
    }
	/**
	 * Test2
	 * 将结果String转换为char数组，在数组中找字符1
	 * 46%
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance02(int x, int y) {
		String s = Integer.toBinaryString(x ^ y);
		char[] a = s.toCharArray();
		int count = 0;
		for(char temp : a){
			if(temp=='1'){
				count ++;
			}
		}
		return count;
    }
	/**
	 * 利用异或、与位运算，及移位运算
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance03(int x, int y){
		int xor = x ^ y , count = 0;
		for(int i = 0; i < 32; i++)	count += (xor >> i) & 1;
		
		return count;
	}
	/**
	 * Test 03
	 * return Integer.bitCount( x ^ y );
	 * Runtime：10ms，77%
	 * 为什么把bitCount方法展开执行会是，Runtime:15ms,8%，不懂
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance04(int x, int y) {
		//return Integer.bitCount(x ^ y);
		int i = x ^ y;
		i = i - ((i >>> 1) & 0x55555555);
	    i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
	    i = (i + (i >>> 4)) & 0x0f0f0f0f;
	    i = i + (i >>> 8);
	    i = i + (i >>> 16);
	    return i & 0x3f;
	}
	
	
	@Test
	public void test(){
		System.out.println(hammingDistance04(1,4));//result : 2
		System.out.println(hammingDistance04(3,11));//result : 1
		System.out.println(Integer.toBinaryString(0x55));//0x55
	}
}
