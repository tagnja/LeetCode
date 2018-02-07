
public class E598_RangeAdditionII{


    public int maxCount(int m, int n, int[][] ops) {
        int width = n, height = m, i;
        for(i = 0; i < ops.length; i++){
            if(ops[i][0] < height)
                height = ops[i][0];
            if(ops[i][1] < width)
                width = ops[i][1];
        }
        return height * width;
    }
}
