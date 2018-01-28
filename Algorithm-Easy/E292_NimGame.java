package com.jack.leetcode.easy;

/**
Description
	You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
	Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
	For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
	Show Hint 
solution:
	There is two people . A present you , B present your friend.
	˼·:��ʯͷ��������ʱ�������Լ�Ӯ�������������1-7������ȷ��˭��Ӯ��8֮���Ҫ������˼������ҪӮ���ǶԷ�Ҫ�䣬����n-1/2/3,���������û�жԷ�������֣����û�У�˵�������ˡ�8���������ˣ�8-1/2/3֮���ǣ�7�� 6�� 5���ǿ���Ӯ�����֡�
	when 
	1 stone , A win
	2 stones , A
	3 stones , A
	4 stones , B
	5 stones , A
	Therefore , n%4==0 , B win ��you lose��
 * @author TaogenJia
 *
 */
public class A292_NimGame {

	public boolean canVinNim(int n){
		if(n%4==0){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		A292_NimGame t6 = new A292_NimGame();
		System.out.println(t6.canVinNim(10));
	}
}
