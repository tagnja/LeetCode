package com.jack.leetcode.easy;

import java.util.Date;

/**
Description:
	Count the number of prime numbers less than a non-negative number, n.

 * @author TaogenJia
 *
 */
public class A204_CountPrimes {
	
	/**
	 * O(n*sqrt(n))
	 * @param n
	 * @return
	 */
	public int countPrimes(int n){
		int result = 0;
		int count = 0;
		for(int i=2;i<n;i++){
			//for(int j=2;j<=Math.sqrt(i);j++){
			for(int j=2;j*j<=i;j++){
				if(i%j==0){
					count ++;
					break;
				}
			}
			if(count==0){
				result++;
			}
			count = 0;
		}
		return result;
	}
	
	/**
	 * O(n)
	 * ����������ų������ų����в��������Ľ�����ų��Ľ��Ϊ��result=����*������result+=������
	 * @param n
	 * @return
	 */
	public int countPrimes2(int n){
		 boolean[] isPrime = new boolean[n];
		   for (int i = 2; i < n; i++) {
		      isPrime[i] = true;
		   }
		   // Loop's ending condition is i * i < n instead of i < sqrt(n)
		   // to avoid repeatedly calling an expensive function sqrt().
		   for (int i = 2; i * i < n; i++) {
		      if (!isPrime[i]) continue;
		      for (int j = i * i; j < n; j += i) {
		         isPrime[j] = false;
		      }
		   }
		   int count = 0;
		   for (int i = 2; i < n; i++) {
		      if (isPrime[i]) count++;
		   }
		   return count;
	}
	
	
	public static void main(String[] args) {
		A204_CountPrimes t5 = new A204_CountPrimes();
		/*System.out.println(new Date());
		System.out.println(t5.countPrimes(60000000));
		System.out.println(new Date());*/
		System.out.println(new Date());
		System.out.println(t5.countPrimes2(100000000));
		System.out.println(new Date());
	}
}
