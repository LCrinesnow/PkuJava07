public class Solution {
    public int addDigits(int num) {
        int tmp = calculate(num);
        while (tmp >= 10){
            tmp = calculate (tmp);
        }
        return tmp;  
    }
    private int calculate (int num){  //...(num) lose int
        int a = 0;
        String s = String.valueOf(num); // String s = String.valueof(num) o should be the bigger O
        for (char c : s.toCharArray()){
            a += (c - '0');
        }
        return a;
     }
}