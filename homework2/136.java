public class Solution { //a ^ a = 0; 0^a = a; T(n) = O(n);
    public int singleNumber(int[] nums) {
        int x = 0;
        for(int i = 0; i < nums.length; i++){
            x = x ^ nums[i];
        }
        return x;
    }
}