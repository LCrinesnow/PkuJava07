public class Solution {
    public int[] twoSum(int[] nums, int target) {
       /* int len = nums.length;
        int sum[] = new int[2];
        int[] number = new int[len];
        int i,j;
        number[0] = nums[0];
        for(i = 1; i < len; i++)
        number[i] = 0;
        for(i = 1; i < len; i++){
            for(j = 0; j < len && number[j]!=0; j++){
                if(number[j]+nums[i] == target){
                    sum[0] = number[j];
                    sum[1] = nums[i];
                    return sum;
                }
            }
        }
        return sum;
    }*/
     HashMap <Integer, Integer> hm = new HashMap<Integer,Integer>(); //HashMap <Integer, Integer> hm = new HashpMap<Integer,Integer>(); //HashMap <Integerr> hm = new HashpMap<Integer>();
    int len = nums.length;
    int[] index =  new int[2];
    for(int i = 0; i < len; i++){
        if(!hm.containsKey(nums[i])){
            hm.put(target - nums[i],i);
        }else{
            index[0] = hm.get(nums[i])+1;
            index[1] = i + 1;
        }
       }
    return index;
    }
    /*int len = nums.length;  排序后索引位置乱了
    int[] index = new int[2];
    Arrays.sort(nums);
    int i = 0; int j = len-1;
    while(i < j){
        if(nums[i]+nums[j] > target)
            j--;
        if(nums[i]+nums[j] < target)
            i++;
        if(nums[i]+nums[j] == target){
            index[0]= i+1;
            index[1]= j+1;
            break;
        }
    }
    return index;
    }*/
}