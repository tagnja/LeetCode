
public class E171_ExcelSheetColumnNumber{

    public int titleToNumber(String s) {
        int minus = 64, radix = 26, result = 0;
        for(int i = s.length() - 1, j = 0; i >= 0; i--, j++){
            result += (s.charAt(i) - 'A' + 1) * Math.pow(radix, j); //char-'A'+1 or char - 64 
        }
        return result;
       
        
        /** Others Excellent Solution 1: Using multiply instead of pow.
        
        int result = 0;
        for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++);
        return result;
        
        */
    }

}
