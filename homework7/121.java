public class Solution {
    public int maxProfit(int[] prices) { //找到prices[i] prices[j]间的最大差价
        if(prices.length == 0) return 0;
        int profit = 0;
        int min = prices[0];
        /*int j = 0; int k = 0; //保存当前最大/小值的位标 第一次出错没有考虑到后面的值比前面的值小的情况
        int min = prices[0];
        int max = prices[0];
        for(int i = 1; i < prices.length; i++){
            if( prices[i] < min) {
                min = prices[i];
                j = i;
            }
            
            if( prices[i] > max) {
                max = prices[i];
                k = i;
            }
        }
        if (j < k) {
        profit = max - min;
        return profit;}
        else return 0;*/
        for(int i = 1; i < prices.length; i++){
            if( prices[i] < min) min = prices[i];
            if (prices[i] - min > profit) profit = prices[i] - min;
        }
        return profit;
    }
}