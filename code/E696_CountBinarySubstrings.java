
public class E696_CountBinarySubstrings{

    public static void main(String[] args){
        System.out.println(new E696_CountBinarySubstrings().countBinarySubstrings("10101"));//print 4
    }

    public int countBinarySubstrings(String s) {

        // Right edition III, O(n)
        int x = 0, y = 0, z = 0, i = 0, result = 0;
        char prev = s.charAt(0);
        while(i < s.length()){
            if(prev != s.charAt(i)){
                prev = s.charAt(i);
                if(y == z && y == 0)
                    y = i;
                else{
                    z = i;
                    result += (y-x) < (z-y) ? y-x : z-y;
                    x = y; 
                    y = z;   
                }
            }
            i++;
        }
        result += (y-x) < (s.length() - y) ? y-x : s.length()-y;
        return result;
        
        
        /*
        // Right edition II, O(n) or O(2n)
        //s.length will be between 1 and 50,000.
        int x = 0, y = 0, z = 0, i = 0, result = 0;
        char prev = s.charAt(0);
        while(i < s.length()){
            if(prev != s.charAt(i)){
                //System.out.println("i:"+i);
                prev = s.charAt(i);
                if(y == z)
                    y = i;
                else{
                    z = i;
                    result += (y-x) < (z-y) ? y-x : z-y;
                    x = z = y; 
                    i = y - 1;
                }
            }
            i++;
        }
        result += (y-x) < (s.length() - y) ? y-x : s.length()-y;
        return result;
        */
        
        /*
        // Right edition I, O(n^2),time limit exceeded.
        int i, j, end, result = 0;
        char flag;
        for(i = 0; i < s.length(); i++){
            flag = s.charAt(i);
            for(j = i+1; j < s.length(); j++){
                if(s.charAt(j) != flag)
                    break;
            }
            end = i + (j - i) * 2;
            for(; j < end && j < s.length(); j++){
                if(s.charAt(j) == flag)
                    break;
            }
            if(j == end)
                result++;
        }
        return result;
        */
    }
}
