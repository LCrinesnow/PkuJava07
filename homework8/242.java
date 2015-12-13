public class Solution {
    public boolean isAnagram(String s, String t) {
        //boolean i = t.contains(s); 这道题的意思就是判断两个字符串中的字母是否一样…- - 排序比较 anagram打乱的字母
        //return i;
        char[]s1 = s.toCharArray();
        char[]t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        String s2 = String.valueOf(s1);
        String t2 = String.valueOf(t1);
        return s2.equals(t2);
    }
}