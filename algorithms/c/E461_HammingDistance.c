/*
 Integer n=(x^y), its binary number have how many 1.
 */
#include<stdio.h>

/*
 method1
 */
int hammingDistance(int x, int y) {
    x ^= y;
    y = 0;
    while(x){
        if((x & 1) == 1){
            y++;
        }
        x >>= 1;
    }
    return y;
}
/*
 method2
 */
int hammingDistance2(int x, int y){
    x ^= y;
    y = 0;
    while(x){
        x = x & (x-1);
        y++;
    }
    return y;

}

int main(){
    int x, y;
    scanf("%d %d",&x,&y);
    int result = hammingDistance2(x,y);
    printf("result %d\n",result);
}
