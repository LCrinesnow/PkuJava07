package sum_4Sum;
import java.util.*;
public class sum_4Sum {
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        
		List<List<Integer>> ret=new ArrayList<List<Integer>>();
        HashSet<ArrayList> NoRepeat=new HashSet<ArrayList>();
        Arrays.sort(nums);//切记 Arrays.
        int first=0;


        while(first<=nums.length-4){
//        target=0-target;//target的相反数
     	System.out.println("1target:"+target);
//        target=target-nums[first];//第一个数的相反数+（-target）
  		System.out.println("2target:"+target);

        int second=first+1;
//        target=target-nums[second];//前两个数和+（-target）的相反数与后两个数的和相等，这样想加起来就是0
 		
        System.out.println("3target:"+target);
        	while(second<=nums.length-3){
        	
        		int i=second+1;
        		int j=nums.length-1;
         		System.out.println("4target:"+target);

        		while(i<j){
        			if(nums[i]+nums[j]+nums[first]+nums[second]==target){
        				ArrayList<Integer> temp=new ArrayList<Integer>();
        				temp.add(nums[first]);
        				temp.add(nums[second]);
        				temp.add(nums[i]);
        				temp.add(nums[j]);
        				
        				if(NoRepeat.add(temp)==true){
        					ret.add(temp);
    		        		System.out.println(nums[i]+"he "+nums[j]);

        				}

        				j--;
        			}
        			else if(nums[i]+nums[j]+nums[first]+nums[second]<target){
        				i++;
        			}
        			else if(nums[i]+nums[j]+nums[first]+nums[second]>target){
        				j--;
        			}
//        			System.out.println("aaa");
        		}
        		second++;
        	}
        	first++;
        }
        for(int a=0;a<ret.size();a++){
			for(int b=0;b<ret.get(a).size();b++){
			System.out.print(ret.get(a).get(b));
			}
			System.out.println();
		}
        return ret;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums={1,0,-1,0,-2,2};
		int target=0;
		List<List<Integer>> receive=new ArrayList<List<Integer>>();
		receive=fourSum(nums,target);
		
	}

}
