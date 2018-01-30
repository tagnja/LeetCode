import java.util.*;

public class E728_SelfDividingNumbers{

    public static void main(String[] args){
        int left = Integer.parseInt(args[0]);
        int right = Integer.parseInt(args[1]);
        List<Integer> list = selfDividingNumbers(left, right);
        System.out.println("list size:"+list.size());
        for(int i : list){
            System.out.print(i+",");
        }
    }

    public static List<Integer> selfDividingNumbers(int left, int right){
    
        int i = 0, number = 0, bit = 0;
        boolean isNumber = false;
        List<Integer> list = new ArrayList<Integer>();
        for(i = left; i <= right; i++){
            number = i;
            isNumber = true;
            while(number > 0){
                bit = number % 10;
                if(bit == 0){
                    isNumber = false;
                    break;
                }
                if(i % bit != 0){
                    isNumber = false;
                    break;
                }
                number = number / 10;
            }
            if(isNumber)
                list.add(i);
        }
        return list;
    }
}
