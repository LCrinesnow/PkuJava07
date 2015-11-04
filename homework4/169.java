public class Solution {
    public int majorityElement(int[] nums) {  //排序后 中位数一定是众数
        Arrays.sort(nums);
        int len = nums.length; //int len = nums.length();
        return nums[len/2];
        /*T = O(n) 的算法
        int cnt = 1;
        int b = num[0];
        for (int i = 1; i < num.size(); i++) {
            if (b == num[i]) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    b = num[i];
                    cnt++;
                }
            }
        }
        return b;*/
    }
}