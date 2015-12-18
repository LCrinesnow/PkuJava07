
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        //if(nums1.length == 0 || nums2.length == 0)
          /*for (int i = 0; i < nums1.length;i++)
          {
              for (int j = 0; j < nums2.length; j++)
              {
                  if (nums2[j] > nums1[i])
                      nums1[i] = nums2[j];
                  else
                     continue;
              }
          }*/
          //将nums2[]里的元素取出来和nums1[]里的元素比较，然后插入nums1[]中
          /*for (int i = 1; i < nums2.length-1 ; i++)
          {
              for (int j = 0; j < nums1.length ; j++)
              {
                  //if (nums2[j] > nums1[i] || nums2[j] == nums1[i])
                  if (nums2[j] < nums1[i-1])
                  {
                      nums1[i+1] = nums2[j];
                      nums1[i+2] = nums1[i+3];
                      
                  }
                  else
                  {
                      i++;
                      continue;
                  }
              }
          }*/
          
          //int p = nums1.length - 1;
          //int q = nums2.length - 1; 
          
          //for ( p = nums1.length - 1; p < m + n - 1; p--)
          //{
              //for ( q = nums2.length - 1; q < m + n - 1; q--)
          //}
          /*while(p > 0 && q > 0)
          {
              if (nums1[p] <= nums2[q])
              {
                  nums1[p++] = nums2[q];
                  q--;
              }
              else
              {
                  p--;
                  //continue;
              }
          }*/
         //使用一个temp作为临时数组 
         /*int temp[] = new int[m+n];
         
         for (int i = 0;i < nums1.length ; i++)
         {
             for (int j = 0;j < nums2.length ; j++)
             {
                 if (nums1[i] > nums2[j])
                 {
                     temp[]
                 }
             }
         }*/
         int p = m - 1;
         int q = n - 1;
         int t = m + n - 1;
         
         
         while ( p >= 0 && q >= 0)
         {
             if (nums1[p] > nums2[q])
             {
                 nums1[t--] = nums1[p--];
             }
             else
             {
                 nums1[t--] = nums2[q--];
             }
         }
    while ( p >= 0)
            nums1[t--] = nums1[p--];
         while (q >= 0)
            nums1[t--] = nums2[q--];
    }
}