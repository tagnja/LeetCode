import java.util.*;

public class E26_RemoveDuplicatesFromSortedArray{

    public static void main(String[] args){
        int[] a = {1,1,2,2,2,3,5};
        System.out.println(removeDuplicates(a));
    }

    public static int removeDuplicates(int[] nums){
        int i = 0, flag = 0, length = 0;
        for(; i < nums.length; i++){
            if(nums[i] != flag){
                length++;
                flag = nums[i];
            }
        }
        return length;
    }

}
