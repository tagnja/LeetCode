## Algorithms Summary

### String

- 两个字符串对比，寻找重复的字母？

i. 对于规模较小的两个字符串，可以使用两个for循环逐一对比。复杂度 O(n)=m*n or n*n  
类似问题：[E771](https://github.com/TaogenJia/LeetCode/blob/master/Algorithm-Easy/E771_JewelsAndStones.java)

### Integer

- 提取一个正整数的每一位？
```
    public List<Integer> getNumberEveryBit(int Number){
        int bit = 0; List<Integer> list = new ArrayList<Integer>();
        while(Number > 0){
            bit = Number % 10;
            list.add(bit);
            Number = Number / 10;
        }
        return list;
    }
```
类似问题：[E728_Self Dividing Numbers](https://github.com/TaogenJia/LeetCode/blob/master/Algorithm/E728_SelfDividingNumbers.java)
