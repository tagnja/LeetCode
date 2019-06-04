### Solution 1: Using HashMap

```java
public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer,Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++)
    {
        if (map.containsKey(target - nums[i]))
        {
            result[0] = map.get(target - nums[i]);
            result[1] = i;
            break;
        }
        else
        {
            map.put(nums[i], i);
        }

    }
    return result;
}
```

Time Complexity: 

for -> O(n)

HashMap -> O(1)

so, T(n) = O(n)