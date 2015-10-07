public class Solution { //T(n) = O(1)
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       // int k = n;  this method cannot caculate the number bigger than 31bit, the type int is signed in java.
       /* if (k == 0)
        return 0;
        int count = 0;
        while(k!= 0){
            if(k % 2 == 1)
            count++;
           else{
                k = k / 2;
           
            k = k / 2;
        }  */
        int count = 0;  //use bit operation 
        while (n!=0){
            count ++;
            n = n&(n-1);
        }
        return count;
    }
}  
