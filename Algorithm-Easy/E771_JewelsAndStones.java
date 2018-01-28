
public class E771_JewelsAndStones{


    public static void main(String[] args){
        String J = "z", S = "ZZ";
        System.out.println("Jewel number is: "+numJewelsInStones(J,S));
    }
    public static int numJewelsInStones(String jewels, String stones){
        int i = 0, j = 0, num = 0;
        for(; i < stones.length(); i++){
            for(j = 0; j < jewels.length(); j++){
                if(stones.charAt(i) == jewels.charAt(j)){
                    num++;
                }
            }
        }
        return num;
    }
}
