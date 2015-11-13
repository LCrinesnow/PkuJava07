package sum_3Sum;
//HashSet+TwoPointer
import java.util.*;
public class sum_3Sum {
	 public static List<List<Integer>> threeSum(int[] nums) {
			Arrays.sort(nums);
		 	List<List<Integer>> ret=new ArrayList<List<Integer>>();
		 	HashSet<ArrayList> NoRepeat=new HashSet();
	        if(nums.length==0) return ret;
		        int i=0;
		        int j=nums.length-1;
		        int first=0;
		        while(first<=nums.length-3){
			        int target=0;
		        	target=target-nums[first];
	         		System.out.println("target:"+target);

		        	i=first+1;
			        j=nums.length-1;
		        	while(i<j){
		    	        ArrayList<Integer> temp=new ArrayList<Integer>();
		        		if(nums[i]+nums[j]==target){
		        			temp.add(nums[first]);
		        			temp.add(nums[i]);
		        			temp.add(nums[j]);
		        			if(NoRepeat.add(temp)==true){
		        				ret.add(temp);
		        			}
			        		
			        		System.out.println(nums[i]+"he "+nums[j]);
			        		j--;
			        	}
		        		else if(nums[i]+nums[j]<target){
			        		System.out.println("小于target："+target+nums[i]+" "+nums[j]);
			        		i++;
			        		
			        	}
		        		else if(nums[i]+nums[j]>target){
			        		System.out.println("大于target："+target+nums[i]+" "+nums[j]);
			        		j--;
			        	}	        		
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
	 public static void main(String []args){
			int nums[]={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
			List<List<Integer>>receive=new ArrayList<List<Integer>>();
			
			receive=threeSum(nums);
			for(int i=0;i<nums.length;i++){
				System.out.print(nums[i]);
			}
//			for(int i=0;i<receive.size();i++){
//				for(int j=0;j<receive.get(i).size();j++)
//				System.out.println(receive.get(i).get(j));
//			}
			
	 }
}
