package date20200214;

import java.util.Arrays;

public class LeetCode01 {
    public static void main(String[] args) {
        int[] a ={15,2,58,62,41,1,57,14,26,77,21,46};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }
        System.out.println();
     //   Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {

            System.out.print(a[i]+"\t");
        }
        System.out.println();
        System.out.println("----------------------------------------");
        Solution solution = new Solution();
        //int target = (int) (Math.random() * 100);
        solution.twoSum(a, 15);
    }
}

class Solution {
    public int[]twoSum(int[] nums, int target) {
        System.out.println("目标值为："+target);
        int[] result = new int[2];
        int[] nums2 = new int[nums.length];
        System.arraycopy(nums, 0, nums2, 0, nums.length);
        System.out.println("原数组长度为："+nums2.length);

        int count = 0;
        Arrays.sort(nums);

        int low = 0, high = nums.length-1;
        while (low <= high) {
            if (nums[low] + nums[high] > target) {
                high--;
            }
            if (nums[low] + nums[high] < target) {
                low++;
            }
            if (nums[low] + nums[high] == target) {
                int low2=0;
                int high2 = nums.length-1;

                while (nums2[low2] != nums[low]) {
                    low2++;
                }
                while (nums2[high2] != nums[high]) {
                    high2--;
                }
                if (low2 > high2) {
                    int temp=0;
                    temp=low2;
                    low2=high2;
                    high2 = temp;
                }
                result[0] = low2;
                result[1] = high2;
                System.out.println("第一个数为："+nums[low]+"\t"+"第二个数为："+nums[high]);
                System.out.println("下标为："+result[0]+"\t"+result[1]);
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("不存在");
            return null;
        }
        return result;
    }
}