public class Solution {
    public String intToRoman(int num) {
      /*1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};

        100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        1000~3000: {"M", "MM", "MMM"}.* 1 4 5 9 10 100 1000基础数字
        I = 1;
        V = 5;
        X = 10;
        L = 50;
        C = 100;
        D = 500;
        M = 1000;*/
    //用贪心算法,每次选最大的value去凑num
    
    String str="";
    String [] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    int [] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};//int [] value = {"1000","900","500","400","100","90","50","40","10","9","5","4","1"};
    for(int i =0; num > 0; i++){
        while(num >= value[i]){
            num = num - value[i];
            str = str + roman[i];
        }
    }
    return str;
        
    }
}