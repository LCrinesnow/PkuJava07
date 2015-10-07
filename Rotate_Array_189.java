public class Solution {//AB->BA (A^-1B^-1)^-1=BA T(n) = O(n)
    public void rotate(int[] nums, int k) {
    /*int len =0;
    len = nums.length;*/
    int len = nums.length;
    k = k % len; //tips: the question does not limit the number of k, k may be larger than the array length 
    if(len==1 || k==0)
    return;
    if(len>1 && k>0) { //judge the length of the array
        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-1);
      }
    }
    public void reverse(int[] num1, int start, int end) {
        int temp = 0;
        while (start < end){
           temp = num1[start];
           num1[start] = num1[end];
           num1[end] = temp;
           start++;
           end--;
       }
    }
}