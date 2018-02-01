
public class E762_PrimeNumberOfSetBits{

    public static void main(String[] args){
        System.out.println(countPrimeSetBits(Integer.parseInt(args[0])
                    , Integer.parseInt(args[1])));
    }

    public static  int countPrimeSetBits(int L, int R) {
        int flag = 0, result = 0;
        for(int i = L; i <= R; i++){
            int num = i;
            while(num > 0){
                num = (num & num-1);
                flag++;
            }
            if(isPrime(flag))
                result++;
            flag = 0;
        }
        return result;
        
    }
    public static boolean isPrime(int num){
        if(num < 2)
            return false;
        if(num == 2)
            return true;
        for(int i = 2; i <= Math.sqrt(num) + 1; i++)
            if(num % i == 0)
                return false;
        return true;
    }

}
