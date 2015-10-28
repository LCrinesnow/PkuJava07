public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>(); 
        while(n!=1){
            if(set.contains(n)) return false;
            else set.add(n);
            int temp = 0;
            String s = String.valueOf(n); 
             for (char c : s.toCharArray())
                 temp += (c-'0')*(c-'0'); // temp += c*c; c is a char; 
            n = temp;
        }
            return true;
    }
}