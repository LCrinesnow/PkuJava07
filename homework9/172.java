public class Solution {//求n中5因子的个数，2X5=10，2一定比5多
    public int trailingZeroes(int n) {
        if(n < 5) return 0;
        int count = 0;
        while(n/5 != 0){
            n = n / 5;
            count += n;
        }
        return count;
    }
}